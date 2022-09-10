package com.example.kotlincleanarchitechture.presentation.meal_search

import com.example.kotlincleanarchitechture.domain.model.Meal

data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = ""
)