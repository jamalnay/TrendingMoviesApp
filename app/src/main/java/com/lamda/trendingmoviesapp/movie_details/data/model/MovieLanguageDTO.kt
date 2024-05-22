package com.lamda.trendingmoviesapp.movie_details.data.model

import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieLanguage
import com.squareup.moshi.Json

data class MovieLanguageDTO(
    @field:Json(name = "english_name")
    val name: String
)

fun MovieLanguageDTO.toMovieLanguage() = MovieLanguage(name)