package com.example.firstapp

import android.app.Person
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: MutableList<Fruit>, val onFruitClick: (Fruit) -> Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val delete: ImageButton
        init {
            textView = view.findViewById(R.id.text_view)
            imageView = view.findViewById(R.id.image)
            delete = view.findViewById(R.id.delete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataList[position].name
        holder.imageView.setImageResource(dataList[position].photo)

        holder.delete.setOnClickListener {
            dataList.removeAt(holder.layoutPosition)
            notifyItemRemoved(position)
        }

        holder.textView.setOnClickListener {
            onFruitClick(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}