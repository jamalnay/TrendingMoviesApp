package com.lamda.ui

import com.lamda.util.Constants.MOVIE_DETAILS_ARGUMENT_KEY

sealed class Destination(val route: String) {
    object MoviesScreen : Destination("home_screen")
    object MovieDetailsScreen : Destination("movie_details_screen/{$MOVIE_DETAILS_ARGUMENT_KEY}")
}