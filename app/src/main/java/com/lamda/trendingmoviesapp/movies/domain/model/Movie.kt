package com.lamda.trendingmoviesapp.movies.domain.model

import com.squareup.moshi.Json

data class Movie(
    @Json(name = "id")
    val id: Int,
    @Json(name = "id")
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String,
)
