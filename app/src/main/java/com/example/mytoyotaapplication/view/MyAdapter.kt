package com.example.mytoyotaapplication.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytoyotaapplication.databinding.ListItemBinding
import com.example.mytoyotaapplication.model.Product

class MyAdapter(val context: Context) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    var myist = listOf<Product>()

    class ItemViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = myist.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = myist[position].title
            Glide.with(holder.binding.root).load(myist[position].thumbnail).into(imageView)
            itemTitle.setOnClickListener() {
                Intent(context, ProductDetails::class.java).apply {
                    putExtra("title", myist[position].title)
                    putExtra("imageuri", myist[position].images?.get(0))
                }.also {
                    context.startActivity(it)
                }
            }
        }
    }

    fun setList(l: List<Product>) {
        myist = l
        notifyDataSetChanged()
    }
}
