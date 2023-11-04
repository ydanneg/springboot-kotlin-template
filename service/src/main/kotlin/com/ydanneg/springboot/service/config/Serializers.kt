package com.ydanneg.springboot.service.config

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder

object Serializers {
    val json = buildWithDefaults()
    val prettyJson = buildWithDefaults { prettyPrint = true }

    private fun buildWithDefaults(builderBlock: JsonBuilder.() -> Unit = {}): Json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        explicitNulls = false
        isLenient = true
        coerceInputValues = true
        this.builderBlock()
    }
}