package com.example.kotlincleanarchitechture.data.remote


import com.example.kotlincleanarchitechture.data.model.MealsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchApi {


    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(
        @Query("s") query: String
    ): MealsDTO

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetails(
        @Query("i") i: String
    ): MealsDTO
}

