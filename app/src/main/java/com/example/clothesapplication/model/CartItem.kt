package com.example.clothesapplication.model

import java.io.Serializable

data class CartItem(
    val subCategoryName: String,
    val selectedServices: List<Service>
) : Serializable
