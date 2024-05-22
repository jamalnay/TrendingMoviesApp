package com.lamda.trendingmoviesapp.movies.data.model

import com.lamda.trendingmoviesapp.movies.domain.model.Movie
import com.squareup.moshi.Json

data class MovieDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "id")
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String,
)

fun MovieDTO.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        posterPath = posterPath
    )
}

