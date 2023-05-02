package com.jorgetranin.listadereceitas.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jorgetranin.listadereceitas.data.entity.Recipe
import com.jorgetranin.listadereceitas.data.entity.RecipeEntity

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipe(): List<RecipeEntity>

    @Insert
    fun insert(recipe: Recipe)
}