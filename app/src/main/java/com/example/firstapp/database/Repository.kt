package com.example.firstapp.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.firstapp.Fruit

class Repository(application: Application) {

    private val fruitDao = FruitDatabase.getDatabase(application).getFruitDao()

    fun addFruit(fruit: Fruit) {
        fruitDao.insertFruit(fruit)
    }

    fun deleteFruit(fruit: Fruit) {
        fruitDao.deleteFruit(fruit)
    }

    fun getAllFruits(): LiveData<List<Fruit>> {
        return fruitDao.getAllFruits()
    }

    fun updateFruit(fruit: Fruit) {
        Log.d("add button: ", fruit.info)
        fruitDao.updateFruit(fruit)
    }

    fun updateFruitInfo(fruit: Fruit, info: String) {
        fruit.info = info
        Log.d("add button: ", fruit.info)
        updateFruit(fruit)
    }
}