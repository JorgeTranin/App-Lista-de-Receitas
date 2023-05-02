package com.jorgetranin.listadereceitas.data.mapper

import com.jorgetranin.listadereceitas.data.entity.RecipeEntity
import com.jorgetranin.listadereceitas.domain.model.RecipeDomain

fun RecipeDomain.toEntity( ) = RecipeEntity(
    id = id,
    name = name
)

fun RecipeEntity.toDomain() = RecipeDomain(
    id = id,
    name = name
)