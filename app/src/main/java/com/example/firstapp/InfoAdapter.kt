package com.example.firstapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter(private val infoList: MutableList<String>): RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        val deleteButton: ImageButton
        init {
            textView = view.findViewById(R.id.info_line)
            deleteButton = view.findViewById(R.id.delete_line)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.info_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = infoList[position]
        holder.deleteButton.setOnClickListener {
            infoList.removeAt(holder.layoutPosition)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

}