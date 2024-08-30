package com.curso.android.marketapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var recyclerView : RecyclerView
    val itemList : ArrayList<Item> = ArrayList()
    lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        itemList.add(Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt"))
        itemList.add(Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans delicious"))
        itemList.add(Item(R.drawable.fruit, "Fruits", "Fresh fruits from the garden"))
        itemList.add(Item(R.drawable.popcorn, "Snacks", "Snacks, Popcorn, Donuts and more"))
        itemList.add(Item(R.drawable.vegitables, "Vegetables", "Fresh vegetables from the garden"))
        itemList.add(Item(R.drawable.beverage, "Beverages", "Juice, Tea, Coffe, Water and Soda"))

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        myAdapter = MyAdapter(itemList)
        recyclerView.adapter = myAdapter

        myAdapter.setClickListener(this)
    }

    override fun onCLick(v: View, pos: Int) {
        Toast.makeText(this, "You Choose: ${itemList[pos].getItemName()}", Toast.LENGTH_SHORT).show()
    }
}