package com.lamda.trendingmoviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lamda.trendingmoviesapp.common.util.Constants

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.MoviesScreen.route
    ) {
        composable(route = Destination.MoviesScreen.route) {

        }
        composable(
            route = Destination.MovieDetailsScreen.route,
            arguments = listOf(navArgument(Constants.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constants.MOVIE_DETAILS_ARGUMENT_KEY)
                ?.let {

                }
        }
    }
}