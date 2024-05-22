package com.lamda.trendingmoviesapp.movie_details.data.model

import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieGenre
import com.squareup.moshi.Json

data class MovieGenreDTO (
    @field:Json(name = "name")
    val genreName: String
)

fun MovieGenreDTO.toMovieGenre() = MovieGenre(genreName)