package com.example.mytoyotaapplication.model


import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("limit")
    var limit: Int? = 0,
    @SerializedName("products")
    var products: List<Product?>? = listOf(),
    @SerializedName("skip")
    var skip: Int? = 0,
    @SerializedName("total")
    var total: Int? = 0
)