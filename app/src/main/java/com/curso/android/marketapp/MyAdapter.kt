package com.curso.android.marketapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(itemList: List<Item>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private val items: List<Item> = itemList
    private var clickListener: ItemClickListener? = null

    fun setClickListener(myListener: ItemClickListener?) {
        this.clickListener = myListener
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val image : ImageView = itemView.findViewById(R.id.recycler_view)
        val tittle : TextView = itemView.findViewById(R.id.title_txt)
        val description : TextView = itemView.findViewById(R.id.description_text)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            clickListener?.onCLick(v, adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.tittle.text = item.getItemName()
        holder.description.text = item.getItemDescription()
        holder.image.setImageResource(item.getItemImg())
    }


}