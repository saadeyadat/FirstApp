package com.example.firstapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//val info: MutableList<String>
@Entity(tableName = "fruitsTable")
data class Fruit(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo") val photo: Int,
    @ColumnInfo(name = "info") var info: String) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}