package com.example.foodie.recipes.usecase

import javax.inject.Inject

interface IGetRecipesUseCase {
    suspend operator fun invoke(): String     //RecipeResponse
}

class GetRecipiesUseCase @Inject constructor(

): IGetRecipesUseCase {
    override suspend fun invoke(): String {
        return ""
    }
}