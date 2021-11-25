package com.example.foodie.recipes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipesScreen(
    meal: String ?
) {
    Text(text = "Recipe of $meal")
    
}