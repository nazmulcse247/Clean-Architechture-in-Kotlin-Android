package com.example.kotlincleanarchitechture.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_tbl")
data class Meal(
    @PrimaryKey(autoGenerate = false)
    val mealId : String,
    val name : String,
    val image : String
)
