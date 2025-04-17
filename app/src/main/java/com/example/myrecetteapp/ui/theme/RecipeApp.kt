package com.example.myrecetteapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navHostController: NavHostController){

    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState //Etat actuel de l'ecran ( liste,erreur....)

    NavHost(navController = navHostController, startDestination = Screen.RecipeScreen.route){
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navHostController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route) {
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }
}

//startDestination c'est l'ecran sur lequel l'app démarre
//navHostController.currentBackStackEntry? Cela fait référence à l'écran actuel dans la pile de navigation.
//savedStateHandle?.set("cat",it)
//C'est une sorte de mémoire temporaire associée à l'écran actuel (dans le back stack).
// set est une méthode qui enregistre des valeurs dans savedStateHandle