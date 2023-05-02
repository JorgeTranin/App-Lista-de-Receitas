package com.jorgetranin.listadereceitas.data.repository

import com.jorgetranin.listadereceitas.data.dao.RecipeDao
import com.jorgetranin.listadereceitas.data.mapper.toDomain
import com.jorgetranin.listadereceitas.data.mapper.toEntity
import com.jorgetranin.listadereceitas.domain.model.RecipeDomain
import com.jorgetranin.listadereceitas.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {
    override suspend fun getAll(): List<RecipeDomain> = withContext(Dispatchers.IO){
        dao.getAllRecipe().map {
            it.toDomain()
        }
    }

    override suspend fun insert(recipe: RecipeDomain) = withContext(Dispatchers.IO){
        dao.insert(recipe.toEntity())
    }
}