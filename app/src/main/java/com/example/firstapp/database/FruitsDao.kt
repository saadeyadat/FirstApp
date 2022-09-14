package com.example.firstapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.firstapp.Fruit

@Dao
interface FruitsDao {

    @Insert
    fun insertFruit(fruit: Fruit)

    @Delete
    fun deleteFruit(fruit: Fruit)

    @Query("Select * from fruitsTable")
    fun getAllFruits(): LiveData<List<Fruit>>

    @Update
    fun updateFruit(fruit: Fruit)

}