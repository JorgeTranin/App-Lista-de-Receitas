package com.jorgetranin.listadereceitas.domain.usecase

import com.jorgetranin.listadereceitas.domain.repository.RecipeRepository

class GetAllRecipesUseCase constructor(private val repository: RecipeRepository)
{
    suspend operator fun invoke() = repository.getAll()
}