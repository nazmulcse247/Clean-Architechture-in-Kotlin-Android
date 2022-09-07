package com.example.kotlincleanarchitechture.domain.repository

import com.example.kotlincleanarchitechture.data.model.MealsDTO


interface MealDetailsRepository {

    suspend fun getMealDetailsList(id : String) : MealsDTO
}