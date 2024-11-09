package com.example.clothesapplication.api

import com.example.clothesapplication.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cartResponse.json")
    suspend fun getData(): Response<ResponseData>
}