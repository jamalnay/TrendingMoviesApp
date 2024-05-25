package com.lamda.moviedetails.data.model

import com.lamda.moviedetails.domain.model.MovieGenre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieGenreDTO (
    @field:Json(name = "name")
    val genreName: String
)

fun MovieGenreDTO.toMovieGenre() = MovieGenre(genreName)