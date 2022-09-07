package com.example.kotlincleanarchitechture.domain.repository

import com.example.kotlincleanarchitechture.data.model.MealsDTO

interface MealSearchRepository {

    suspend fun getMealList(s : String) : MealsDTO

}