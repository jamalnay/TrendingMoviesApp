package com.lamda.trendingmoviesapp.common.util

import com.lamda.trendingmoviesapp.BuildConfig

object Constants {
    const val BASE_URL = BuildConfig.BASE_URL
    const val API_KEY = BuildConfig.API_KEY
    const val CACHE_AGE = 30 //in days
    //poster sizes: "w92","w154","w185","w342","w500","w780","original"
    const val POSTERS_BASE_URL = "https://image.tmdb.org/t/p/w500"
    const val MOVIE_DETAILS_ARGUMENT_KEY = "movieId"
}