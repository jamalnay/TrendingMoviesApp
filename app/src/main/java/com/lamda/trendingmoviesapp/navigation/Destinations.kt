package com.lamda.trendingmoviesapp.navigation

import com.lamda.trendingmoviesapp.common.util.Constants.MOVIE_DETAILS_ARGUMENT_KEY

sealed class Destination(val route: String) {
    object MoviesScreen : Destination("home_screen")
    object MovieDetailsScreen : Destination("movie_details_screen/{$MOVIE_DETAILS_ARGUMENT_KEY}")
}