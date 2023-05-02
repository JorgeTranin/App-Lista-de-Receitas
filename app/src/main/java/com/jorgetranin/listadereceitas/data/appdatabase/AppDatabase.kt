package com.jorgetranin.listadereceitas.data.appdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jorgetranin.listadereceitas.data.dao.RecipeDao
import com.jorgetranin.listadereceitas.data.entity.Recipe


@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "app_db"
            ).fallbackToDestructiveMigration()
                .build()
    }
}