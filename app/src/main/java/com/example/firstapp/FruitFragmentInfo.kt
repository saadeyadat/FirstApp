package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment


class FruitFragmentInfo(private val fruit: Fruit): Fragment(R.layout.fruit_info_fragment) {

    override fun onResume() {
        super.onResume()
        val fruitInfo = activity?.findViewById<TextView>(R.id.fragment_view_on_info)
        val addText = activity?.findViewById<EditText>(R.id.add_text)
        val addButton = activity?.findViewById<ImageButton>(R.id.add_button)
        val exitButton = activity?.findViewById<ImageButton>(R.id.exit_button2)

        addButton?.setOnClickListener {
            fruitInfo?.text = addText?.text.toString()
        }

        exitButton?.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }
}