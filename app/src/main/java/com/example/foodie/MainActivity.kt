package com.example.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.foodie.meal.MealScreen
import com.example.foodie.recipes.RecipesScreen
import dagger.hilt.android.AndroidEntryPoint
import com.example.foodie.ui.theme.FoodieTheme as FoodieTheme1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieTheme1 {
                FoodieApp()
            }
        }
    }
}

@Composable
fun FoodieApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "meal" ){
        composable("meal") {
            MealScreen{ meal ->
                navController.navigate("recipes/${meal}")
            }
        }
        composable("recipes/{meal}", arguments = listOf(navArgument("meal"){
            type = NavType.StringType
        })) {
            val mealStr = remember {
                it.arguments?.getString("meal")
            }
            RecipesScreen(mealStr)
        }
    }

    //MealScreen()
    //RecipesScreen()
}
