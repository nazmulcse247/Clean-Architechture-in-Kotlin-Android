package com.example.kotlincleanarchitechture

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
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

        viewModel.getSearchMeals("chicken")

       /* binding!!.mealSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String?): Boolean {
                s?.let {
                    Log.d(TAG, "onQueryTextSubmit"+it)
                    viewModel.getSearchMeals(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })*/

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealSearchList.collect {

                if (it.isLoading) {

                    binding!!.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {

                    binding!!.progressBar.visibility = View.GONE
                }

                it.data?.let {

                    if (it.isEmpty()) {
                        binding!!.progressBar.visibility = View.VISIBLE
                    }

                    Log.d(TAG, "list size"+ it.size.toString())
                    Toast.makeText(this@MainActivity,"size "+ it.size.toString(),Toast.LENGTH_LONG).show()
                    binding!!.progressBar.visibility = View.GONE

                }


            }
        }
    }
}