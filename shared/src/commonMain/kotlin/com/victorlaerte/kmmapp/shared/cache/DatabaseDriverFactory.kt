package com.victorlaerte.kmmapp.shared.cache

import com.squareup.sqldelight.db.SqlDriver

/**
 * @author Victor Oliveira
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}