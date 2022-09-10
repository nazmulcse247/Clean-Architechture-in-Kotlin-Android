package com.example.kotlincleanarchitechture

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import com.example.kotlincleanarchitechture.databinding.ActivityMainBinding
import com.example.kotlincleanarchitechture.presentation.meal_search.MealSearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null

    private val viewModel: MealSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)



      //  viewModel.getSearchMeals("chicken")

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealSearchList.collect {

                if (it.isLoading) {

                }
                if (it.error.isNotBlank()) {

                }

                it.data?.let {

                    Log.d(TAG, "onCreate: "+ it.toMutableList())
                    if (it.isEmpty()) {

                    }
                   Toast.makeText(this@MainActivity,"size "+ it.toMutableList().size.toString(),Toast.LENGTH_LONG).show()
                }


            }
        }
    }
}