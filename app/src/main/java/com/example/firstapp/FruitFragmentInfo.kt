package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class FruitFragmentInfo(private val fruit: Fruit): Fragment(R.layout.fruit_info_fragment) {

    override fun onResume() {
        super.onResume()
        val addText = activity?.findViewById<EditText>(R.id.add_text)
        val addButton = activity?.findViewById<ImageButton>(R.id.add_button)
        val exitButton = activity?.findViewById<ImageButton>(R.id.exit_button2)

        addButton?.setOnClickListener {
            fruit.info.add("${fruit.info.size+1}. ${addText?.text.toString()}")
            infoRecyclerView()
        }

        exitButton?.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }

    private fun infoRecyclerView() {
        val infoRecyclerView = activity?.findViewById<RecyclerView>(R.id.infoRecyclerView)
        val infoAdapter = InfoAdapter(fruit.info)
        infoRecyclerView?.adapter = infoAdapter
    }
}