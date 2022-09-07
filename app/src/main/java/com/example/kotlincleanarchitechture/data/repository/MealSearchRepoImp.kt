package com.example.kotlincleanarchitechture.data.repository

import com.example.kotlincleanarchitechture.data.model.MealsDTO
import com.example.kotlincleanarchitechture.data.remote.MealSearchApi
import com.example.kotlincleanarchitechture.domain.repository.MealSearchRepository

class MealSearchRepoImp (private val mealSearchApi: MealSearchApi) : MealSearchRepository {
    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchApi.getMeals(s)
    }
}