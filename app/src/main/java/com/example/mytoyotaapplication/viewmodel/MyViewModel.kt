package com.example.mytoyotaapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mytoyotaapplication.model.Product
import com.example.mytoyotaapplication.network.MyRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {
    val myList = MutableLiveData<List<Product>>()
    fun LoadAll() {
        viewModelScope.launch() {
            myList.postValue(withContext(Dispatchers.IO) {
                MyRetrofit().getService().getAll().body()?.products ?: listOf<Product>()
            } as List<Product>?)
        }
    }
}
