package com.example.firstapp.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.firstapp.Fruit

class Repository private constructor(application: Context?) {

    private val fruitDao = FruitDatabase.getDatabase(application).getFruitDao()

    companion object {
        private lateinit var instance: Repository
        fun getInstance(application: Context?): Repository {
            if (!::instance.isInitialized)
                instance = Repository(application)
            return instance
        }
    }

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