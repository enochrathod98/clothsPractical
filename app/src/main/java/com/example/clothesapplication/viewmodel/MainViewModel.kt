package com.example.clothesapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clothesapplication.model.ResponseData
import com.example.clothesapplication.repository.DataRepository
import com.example.clothesapplication.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = DataRepository()
    val data = MutableLiveData<Resource<ResponseData>>()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            data.postValue(repository.getData())
        }
    }
}