package com.jorgetranin.listadereceitas.domain.usecase

import com.jorgetranin.listadereceitas.domain.model.RecipeDomain
import com.jorgetranin.listadereceitas.domain.repository.RecipeRepository

class InsertRecipeUseCase  constructor(private val repository: RecipeRepository) {
    suspend operator fun invoke(recipe:RecipeDomain) = repository.insert(recipe)
}