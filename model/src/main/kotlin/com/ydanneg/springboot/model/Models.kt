package com.ydanneg.springboot.model

import kotlinx.serialization.Serializable

@Serializable
data class Model1(
    val id: String,
    val name: String
)