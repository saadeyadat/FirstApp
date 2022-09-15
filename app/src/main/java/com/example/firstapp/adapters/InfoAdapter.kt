package com.example.firstapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.Fruit
import com.example.firstapp.R
import com.example.firstapp.database.Repository
import kotlin.concurrent.thread

class InfoAdapter(private val fruit: Fruit, private val context: Context?): RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    private var infoList: MutableList<String> = fruit.info.split(',').toMutableList() // convert info string to list to show it via recyclerview
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
            fruit.info = infoList.joinToString(",") // covert back the list to string to save it in the database
            thread(start = true) {
                Repository.getInstance(context).updateFruitInfo(fruit, fruit.info)
            }
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return infoList.size-1
    }
}