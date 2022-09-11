package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment


class FruitFragmentInfo: Fragment(R.layout.fruit_info_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fruitInfo = activity?.findViewById<TextView>(R.id.fragment_view_on_info)

        fruitInfo?.text = "info."
    }
}