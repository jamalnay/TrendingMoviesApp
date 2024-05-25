package com.lamda.moviedetails.data.model

import com.lamda.moviedetails.domain.model.MovieLanguage
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieLanguageDTO(
    @field:Json(name = "english_name")
    val name: String
)

fun MovieLanguageDTO.toMovieLanguage() = MovieLanguage(name)