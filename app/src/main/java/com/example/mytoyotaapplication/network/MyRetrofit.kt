package com.example.mytoyotaapplication.network

import com.example.mytoyotaapplication.model.Products
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MyRetrofit {
    companion object {
        fun makeRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com").addConverterFactory(
            GsonConverterFactory.create(),
        ).build()
    }
    fun getService(): RetrofitService = makeRetrofit().create(RetrofitService::class.java)
}

interface RetrofitService {
    @GET("/products")
    suspend fun getAll(): Response<Products>
}
