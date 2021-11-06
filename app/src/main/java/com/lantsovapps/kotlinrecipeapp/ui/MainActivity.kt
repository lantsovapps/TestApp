package com.lantsovapps.kotlinrecipeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lantsovapps.kotlinrecipeapp.R
import com.lantsovapps.kotlinrecipeapp.domain.Domain
import com.lantsovapps.kotlinrecipeapp.domain.IDomain
import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe
import com.lantsovapps.kotlinrecipeapp.network.INetwork
import com.lantsovapps.kotlinrecipeapp.ui.adapter.CustomAdapter

class MainActivity: AppCompatActivity(), IView{

    lateinit var btn_start : Button
    lateinit var text : TextView
    lateinit var rView : RecyclerView
    lateinit var layoutManager: LinearLayoutManager

    var domain: Domain = Domain(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        btn_start.setOnClickListener {
            println("debug: Click")
            find()
        }

    }

    private fun init(){
        btn_start = findViewById(R.id.btn_start)
        text = findViewById(R.id.txt_view)
        rView = findViewById(R.id.recyclerView)
        rView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        rView.layoutManager = layoutManager
    }

    private fun find(){
        findRecipes()
    }

    override fun findRecipes() {
        domain.networkData()
    }

    override fun setRecipes(listRecipes : ArrayList<Recipe>) {
        println("debug: in setPrices: ${listRecipes.size}")
        val adapter  = CustomAdapter(listRecipes, baseContext)
        adapter.notifyDataSetChanged()
        rView.adapter = adapter

        setFoundNumber(listRecipes.size)
    }

    private fun setFoundNumber(number:Int){
        text.text = "$number recipes found"
    }

    fun showErrorToast(){
        Toast.makeText(baseContext, "No connection", Toast.LENGTH_SHORT).show()
    }
}
