package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val fruitList = mutableListOf<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         imageSelector()
    }

    private fun imageSelector() {
        val banana = findViewById<AppCompatButton>(R.id.banana)
        val apple = findViewById<AppCompatButton>(R.id.apple)
        val avocado = findViewById<AppCompatButton>(R.id.avocado)

        banana.setOnClickListener { clickListen(R.drawable.banana) }
        apple.setOnClickListener { clickListen(R.drawable.apple) }
        avocado.setOnClickListener { clickListen(R.drawable.avocado) }
    }

    private fun clickListen(image: Int) {
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            val text = editText.text.toString()
            fruitList.add(Fruit("${fruitList.size + 1}. " + text, image, "No Info."))
            recyclerView()
        }
    }

    private fun recyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyAdapter(fruitList){
            displayFruitFragment(it)
        }
        recyclerView.adapter = adapter
    }

    /*-------------------Fragments-------------------*/

    private fun displayFruitFragment(fruit: Fruit) {
        val bundle = bundleOf("fruitName" to fruit.name, "fruitImage" to fruit.photo)
        val fruitFragment = FruitFragment(fruit)
        fruitFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, fruitFragment).commit()
    }
}