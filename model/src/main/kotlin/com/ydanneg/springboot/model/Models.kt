package com.ydanneg.springboot.model

import kotlinx.serialization.Serializable

@Serializable
data class Model(
    val id: String,
    val name: String
)

@Serializable
data class CreateModelRequest(val name: String)
