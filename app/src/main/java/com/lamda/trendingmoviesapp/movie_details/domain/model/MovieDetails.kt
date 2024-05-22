package com.lamda.trendingmoviesapp.movie_details.domain.model


data class MovieDetails(
    val movieId: Int,
    val title: String,
    val releaseDate: String,
    val genres: List<MovieGenre>,
    val voteAverage: Double,
    val voteCount: Int,
    val posterPath: String,
    val overview: String,
    val country:List<String>,
    val movieLanguage:List<MovieLanguage>,
)

