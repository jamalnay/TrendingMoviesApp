package com.lamda.moviedetails.data.model

import com.lamda.moviedetails.domain.model.MovieDetails
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsResult(
    @field:Json(name = "id")
    val movieId: Int,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "release_date")
    val releaseDate: String,
    @field:Json(name = "genres")
    val genres: List<MovieGenreDTO>,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "vote_count")
    val voteCount: Int,
    @field:Json(name = "poster_path")
    val posterPath: String,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "origin_country")
    val country:List<String>,
    @field:Json(name = "spoken_languages")
    val movieLanguage:List<MovieLanguageDTO>,
    )

fun MovieDetailsResult.toMovieDetails(): MovieDetails {
    return MovieDetails(
        movieId = movieId,
        title = title,
        releaseDate = releaseDate,
        genres = genres.map { it.toMovieGenre() },
        voteAverage = voteAverage,
        voteCount = voteCount,
        posterPath = posterPath,
        overview = overview,
        country = country,
        movieLanguage = movieLanguage.map { it.toMovieLanguage() }
    )
}

