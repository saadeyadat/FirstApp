package com.example.firstapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstapp.Fruit

@Database(entities = arrayOf(Fruit::class), version = 1)
abstract class FruitDatabase: RoomDatabase() {

    abstract fun getFruitDao(): FruitsDao

    companion object {
        fun getDatabase(context: Context?): FruitDatabase {
            return Room.databaseBuilder(
                context!!.applicationContext,
                FruitDatabase::class.java,
                "fruit_database"
            ).build()
        }
    }
}