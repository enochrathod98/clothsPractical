package com.example.clothesapplication.model

data class ResponseData(
    val sub_categories: List<SubCategory>,
    val products: List<Product>,
    val services: List<Service>,
    val status: String,
    val message: String
)
