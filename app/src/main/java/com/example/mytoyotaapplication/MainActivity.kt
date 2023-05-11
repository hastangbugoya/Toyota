package com.example.mytoyotaapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mytoyotaapplication.databinding.ActivityMainBinding
import com.example.mytoyotaapplication.view.MyAdapter
import com.example.mytoyotaapplication.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    val myViewModel: MyViewModel by viewModels()
    val myMainAdapter: MyAdapter by lazy {
        MyAdapter(this)
    }
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainRecycler.adapter = myMainAdapter
        myViewModel.myList.observe(this) {
            myMainAdapter.setList(it)
        }

        myViewModel.LoadAll()
    }
}
