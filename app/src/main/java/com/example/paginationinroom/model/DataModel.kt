package com.example.paginationinroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sampleData")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val age: Int
)