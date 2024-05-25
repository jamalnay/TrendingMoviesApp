package com.lamda.moviedetails.domain.repository

import com.lamda.moviedetails.data.model.ResultSet
import com.lamda.moviedetails.domain.model.MovieDetails

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): ResultSet<MovieDetails>
}
