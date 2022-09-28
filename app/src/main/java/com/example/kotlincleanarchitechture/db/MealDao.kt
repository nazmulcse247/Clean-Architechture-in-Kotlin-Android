package com.example.kotlincleanarchitechture.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincleanarchitechture.domain.model.Meal

@Dao
interface MealDao {

    @Insert
    suspend fun insertMealList(mealList: List<Meal>)

    @Query("SELECT * FROM meal_tbl")
    suspend fun getMealList(): List<Meal>
}