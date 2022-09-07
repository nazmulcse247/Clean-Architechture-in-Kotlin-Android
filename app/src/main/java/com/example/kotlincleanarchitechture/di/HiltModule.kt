package com.example.kotlincleanarchitechture.di

import com.example.kotlincleanarchitechture.common.Utils.BASE_URL
import com.example.kotlincleanarchitechture.data.remote.MealSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class HiltModule {


    @Provides
    @Singleton
    fun getMealSearchApi() : MealSearchApi{

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealSearchApi::class.java)
    }


}