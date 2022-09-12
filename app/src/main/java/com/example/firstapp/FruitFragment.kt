package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FruitFragment(private val fruit: Fruit): Fragment(R.layout.fruit_fragment) {

    private val fruitFragmentInfo = FruitFragmentInfo(fruit)
    override fun onResume() {
        super.onResume()
        val fruitTextView = activity?.findViewById<TextView>(R.id.fruit_title)  // ? - is to insure that we don't give null
        val fruitImageView = activity?.findViewById<ImageView>(R.id.fruit_image)
        val fruitInfoView = activity?.findViewById<TextView>(R.id.fruit_info)
        val exitMainButton = activity?.findViewById<ImageButton>(R.id.exit_button)

        val name = requireArguments().getString("fruitName")
        val image = requireArguments().getInt("fruitImage")

        fruitTextView?.text = name.toString()
        fruitImageView?.setImageResource(image)

        fruitInfoView?.setOnClickListener {
            childFragmentManager.beginTransaction().replace(R.id.fragment_view_info, fruitFragmentInfo).commit()
        }

        exitMainButton?.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }
}