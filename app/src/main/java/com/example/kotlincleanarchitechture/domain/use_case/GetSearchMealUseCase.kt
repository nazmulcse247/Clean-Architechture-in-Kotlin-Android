package com.example.kotlincleanarchitechture.domain.use_case


import com.example.kotlincleanarchitechture.common.Resource

import com.example.kotlincleanarchitechture.domain.model.Meal
import com.example.kotlincleanarchitechture.domain.repository.MealSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import toDomainMeal
import java.io.IOException
import javax.inject.Inject

class GetSearchMealUseCase @Inject constructor(private val repository: MealSearchRepository){

    operator fun invoke(q: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealList(q)
            val domainData =
                if (data.meals != null)
                    data.meals.map { it ->
                    it.toDomainMeal()
                    }
                else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }

}