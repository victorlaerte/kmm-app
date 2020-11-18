package com.victorlaerte.kmmapp.shared

import com.victorlaerte.kmmapp.shared.cache.Database
import com.victorlaerte.kmmapp.shared.cache.DatabaseDriverFactory
import com.victorlaerte.kmmapp.shared.entity.RocketLaunch
import com.victorlaerte.kmmapp.shared.network.SpaceXApi

/**
 * @author Victor Oliveira
 */
class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}