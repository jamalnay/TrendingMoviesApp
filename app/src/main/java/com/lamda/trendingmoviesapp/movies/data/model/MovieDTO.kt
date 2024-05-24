package com.lamda.trendingmoviesapp.movies.data.model

import com.lamda.trendingmoviesapp.movies.domain.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "title")
    val title: String
)

fun MovieDTO.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        posterPath = posterPath
    )
}

