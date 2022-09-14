package com.example.firstapp.fragments

import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.Fruit
import com.example.firstapp.R
import com.example.firstapp.adapters.InfoAdapter
import com.example.firstapp.database.Repository
import kotlin.concurrent.thread

class FruitFragmentInfo(private val fruit: Fruit, private val repository: Repository): Fragment(R.layout.fruit_info_fragment) {

    override fun onResume() {
        super.onResume()
        val addText = activity?.findViewById<EditText>(R.id.add_text)
        val addButton = activity?.findViewById<ImageButton>(R.id.add_button)
        val exitButton = activity?.findViewById<ImageButton>(R.id.exit_button2)

        addButton?.setOnClickListener {
            fruit.info += addText?.text.toString() + ','
            thread(start = true) {
                repository.updateFruitInfo(fruit, fruit.info)
            }
            infoRecyclerView()
        }

        exitButton?.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }

    private fun infoRecyclerView() {
        val infoRecyclerView = activity?.findViewById<RecyclerView>(R.id.infoRecyclerView)
        val infoAdapter = InfoAdapter(fruit, repository)
        infoRecyclerView?.adapter = infoAdapter
    }
}