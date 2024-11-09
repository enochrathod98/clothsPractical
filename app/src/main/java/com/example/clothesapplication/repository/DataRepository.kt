package com.example.clothesapplication.repository

import com.example.clothesapplication.api.ApiClient
import com.example.clothesapplication.model.ResponseData
import com.example.clothesapplication.utils.Resource

class DataRepository {
    suspend fun getData(): Resource<ResponseData> {
        return try {
            val response = ApiClient.apiService.getData()
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("An error occurred: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("An error occurred: ${e.localizedMessage}")
        }
    }
}