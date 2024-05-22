package com.lamda.trendingmoviesapp.movies.data.model

import com.lamda.trendingmoviesapp.movie_details.data.model.MovieDetailsDTO
import com.lamda.trendingmoviesapp.movie_details.data.model.toMovieDetails
import com.lamda.trendingmoviesapp.movies.domain.model.Movies
import com.squareup.moshi.Json

data class MoviesDTO(
    @field:Json(name = "page")
    val page:Int,
    @field:Json(name = "results")
    val results:List<MovieDetailsDTO>,
    @field:Json(name = "total_pages")
    val totalPages:Int,
    @field:Json(name = "total_results")
    val totalResults:Int
)

fun MoviesDTO.toMovies(): Movies {
    return Movies(
        page = this.page,
        results = this.results.map { it.toMovieDetails() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}
