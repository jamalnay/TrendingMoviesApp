package com.lamda.trendingmoviesapp.movies.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResult(
    @field:Json(name = "page")
    val page:Int,
    @field:Json(name = "results")
    val results:List<MovieDTO>,
    @field:Json(name = "total_pages")
    val totalPages:Int,
    @field:Json(name = "total_results")
    val totalResults:Int
)

