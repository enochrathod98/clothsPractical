package com.example.clothesapplication.model

import java.io.Serializable

data class Service(
    val service_id: String,
    val service_name: String,
    val service_icon: String
) : Serializable
