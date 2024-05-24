package com.lamda.trendingmoviesapp.movie_details.domain.repository

import com.lamda.trendingmoviesapp.movie_details.data.model.ResultSet
import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): ResultSet<MovieDetails>
}
