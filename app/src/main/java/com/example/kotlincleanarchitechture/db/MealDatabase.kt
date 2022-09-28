package com.example.kotlincleanarchitechture.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlincleanarchitechture.domain.model.Meal

@Database(
    entities = [Meal::class],
    version = 1
)
abstract class MealDatabase : RoomDatabase(){

    abstract fun mealDao() : MealDao

    companion object {

        @Volatile
        private var INSTANCE : MealDatabase? = null

        fun getMealDatabase(context: Context) : MealDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,MealDatabase::class.java,"mealDB").build()
                }
            }
            return INSTANCE!!
        }
    }

}