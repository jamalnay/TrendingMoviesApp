package com.lamda.trendingmoviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.lamda.trendingmoviesapp.common.util.Constants.MOVIE_DETAILS_ARGUMENT_KEY
import com.lamda.trendingmoviesapp.movie_details.presentation.ui.MovieDetailsScreen
import com.lamda.trendingmoviesapp.movies.presentation.MoviesViewModel
import com.lamda.trendingmoviesapp.movies.presentation.ui.MoviesScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    val viewModel = hiltViewModel<MoviesViewModel>()
    val movies = viewModel.getMovies().collectAsLazyPagingItems()
    NavHost(
        navController = navController,
        startDestination = Destination.MoviesScreen.route
    ) {
        composable(route = Destination.MoviesScreen.route) {
            MoviesScreen(
                navController = navController,
                movies = movies
            )
        }
        composable(
            route = Destination.MovieDetailsScreen.route.plus("/{$MOVIE_DETAILS_ARGUMENT_KEY}")
        ) { backStackEntry ->
            MovieDetailsScreen(
                movieId = backStackEntry.arguments?.getString(MOVIE_DETAILS_ARGUMENT_KEY) ?: ""
            ) { navController.navigateUp() }
        }
    }
}