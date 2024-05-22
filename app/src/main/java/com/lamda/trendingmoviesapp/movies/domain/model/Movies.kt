package com.lamda.trendingmoviesapp.movies.domain.model

import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails

data class Movies(
    val page:Int,
    val results:List<MovieDetails>,
    val totalPages:Int,
    val totalResults:Int
)

