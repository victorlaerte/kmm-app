package com.victorlaerte.kmmapp.shared.cache.script

import kotlin.String

data class Rocket(
  val id: String,
  val name: String,
  val type: String
) {
  override fun toString(): String = """
  |Rocket [
  |  id: $id
  |  name: $name
  |  type: $type
  |]
  """.trimMargin()
}
