package com.example.myshop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_list.view.*

class ProductsAdapter(var context:Context, var contacts:List<ProductItem>): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(
                    R.layout.product_list,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = contacts.get(position).name
        holder.cost.text = contacts.get(position).cost.toString()
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name = view.name
        val cost = view.cost
    }
}

