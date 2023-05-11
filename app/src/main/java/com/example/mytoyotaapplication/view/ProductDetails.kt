package com.example.mytoyotaapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.mytoyotaapplication.R
import com.example.mytoyotaapplication.databinding.ProductDetailsBinding

class ProductDetails : AppCompatActivity() {
    val binding : ProductDetailsBinding by lazy {
        ProductDetailsBinding.inflate(LayoutInflater.from(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView.text = intent.getStringExtra("title")
        Glide.with(this).load(intent.getStringExtra("imageuri")).into(binding.imageView2)

    }
}