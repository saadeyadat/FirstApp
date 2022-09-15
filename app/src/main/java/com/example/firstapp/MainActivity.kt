package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.adapters.MyAdapter
import com.example.firstapp.database.Repository
import com.example.firstapp.fragments.FruitFragment
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
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
            thread(start = true) {
                Repository.getInstance(this).addFruit(Fruit(text, image, String()))
            }
            recyclerView()
        }
    }

    private fun recyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyAdapter(mutableListOf(), this){ displayFruitFragment(it) }
        recyclerView.adapter = adapter
        Repository.getInstance(this).getAllFruits().observe(this) { adapter.updateView(it) }
    }

    private fun displayFruitFragment(fruit: Fruit) {
        val bundle = bundleOf("fruitName" to fruit.name, "fruitImage" to fruit.photo)
        val fruitFragment = FruitFragment(fruit, this)
        fruitFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, fruitFragment).commit()
    }
}