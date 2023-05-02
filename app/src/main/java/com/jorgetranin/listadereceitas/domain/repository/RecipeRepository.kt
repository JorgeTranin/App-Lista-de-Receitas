package com.jorgetranin.listadereceitas.domain.repository

import com.jorgetranin.listadereceitas.domain.model.RecipeDomain


interface RecipeRepository {
    suspend fun getAll(): List<RecipeDomain>
    suspend fun insert(recipe : RecipeDomain)
}