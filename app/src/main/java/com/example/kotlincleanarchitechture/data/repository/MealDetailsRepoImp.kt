package com.example.kotlincleanarchitechture.data.repository

import com.example.kotlincleanarchitechture.data.model.MealsDTO
import com.example.kotlincleanarchitechture.data.remote.MealSearchApi
import com.example.kotlincleanarchitechture.domain.repository.MealDetailsRepository

class MealDetailsRepoImp (private val mealSearchApi: MealSearchApi) : MealDetailsRepository {

    override suspend fun getMealDetailsList(id: String): MealsDTO {
        return mealSearchApi.getMealDetails(id)
    }
}