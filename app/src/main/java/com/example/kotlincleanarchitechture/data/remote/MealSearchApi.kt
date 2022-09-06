package com.example.kotlincleanarchitechture.data.remote

import com.example.kotlincleanarchitechture.data.model.MealsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchApi {


    @GET("json/v1/1/search.php")
    suspend fun getMeals(
        @Query("s") s : String
    ) : Response<MealsDTO>
}
