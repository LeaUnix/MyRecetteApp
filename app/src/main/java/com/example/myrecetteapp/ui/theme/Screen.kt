package com.example.myrecetteapp.ui.theme

sealed class Screen(val route: String){

    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")

}

//Tu crées une classe scellée (sealed = fermée) qui représente tous les écrans possibles de ton app.
//Elle prend un paramètre route, un String,
//qui représente le nom de la route pour la navigation (ex: dans un NavHost).


// object RecipeScreen: NavigateScreen("recipescreen") :
// Il hérite de NavigateScreen, donc il a un route = "recipescreen".