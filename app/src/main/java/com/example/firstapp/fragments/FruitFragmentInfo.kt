package com.example.firstapp.fragments

import android.content.Context
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.Fruit
import com.example.firstapp.R
import com.example.firstapp.adapters.InfoAdapter
import com.example.firstapp.database.Repository
import kotlin.concurrent.thread

class FruitFragmentInfo(private val fruit: Fruit, context: Context): Fragment(R.layout.fruit_info_fragment) {

    override fun onResume() {
        super.onResume()
        val addText = activity?.findViewById<EditText>(R.id.add_text)
        val addButton = activity?.findViewById<ImageButton>(R.id.add_button)
        val exitButton = activity?.findViewById<ImageButton>(R.id.exit_button2)

        addButton?.setOnClickListener {
            fruit.info += addText?.text.toString() + ','
            thread(start = true) {
                Repository.getInstance(context).updateFruitInfo(fruit, fruit.info)
            }
            infoRecyclerView()
        }

        exitButton?.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }

    private fun infoRecyclerView() {
        val infoRecyclerView = activity?.findViewById<RecyclerView>(R.id.infoRecyclerView)
        val infoAdapter = InfoAdapter(fruit, context)
        infoRecyclerView?.adapter = infoAdapter
    }
}