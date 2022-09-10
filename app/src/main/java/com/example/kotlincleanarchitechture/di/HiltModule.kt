package com.example.kotlincleanarchitechture.di

import com.example.kotlincleanarchitechture.common.Utils.BASE_URL
import com.example.kotlincleanarchitechture.data.remote.MealSearchApi
import com.example.kotlincleanarchitechture.data.repository.MealDetailsRepoImp
import com.example.kotlincleanarchitechture.data.repository.MealSearchRepoImp
import com.example.kotlincleanarchitechture.domain.repository.MealDetailsRepository
import com.example.kotlincleanarchitechture.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModule {


    @Provides
    @Singleton
    fun getMealSearchApi() : MealSearchApi{

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealSearchApi::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSearchApi: MealSearchApi) : MealSearchRepository{
        return MealSearchRepoImp(mealSearchApi)
    }

    @Provides
    fun provideMealDetailsRepository(mealSearchApi: MealSearchApi) : MealDetailsRepository{
        return MealDetailsRepoImp(mealSearchApi)
    }


}