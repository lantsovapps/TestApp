package com.lantsovapps.kotlinrecipeapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lantsovapps.kotlinrecipeapp.R
import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe
import com.squareup.picasso.Picasso

class CustomAdapter (private val data : ArrayList<Recipe>, val context : Context)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val name : TextView = view.findViewById(R.id.foodName)
        val image : ImageView = view.findViewById(R.id.foodImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = data[position]
        val url = recipe.image
        Picasso.with(context).load(url).into(holder.image)
        holder.name.text = recipe.title
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Clicked on ${recipe.title}", Toast.LENGTH_SHORT).show()
        }
    }

}