package com.lamda.trendingmoviesapp.navigation

sealed class Destination(val route: String) {
    object MoviesScreen : Destination("home_screen")
    object MovieDetailsScreen : Destination("movie_details_screen/{movieId}")
}