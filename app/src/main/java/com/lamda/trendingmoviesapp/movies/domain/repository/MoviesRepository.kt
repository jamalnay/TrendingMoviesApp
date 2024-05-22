package com.lamda.trendingmoviesapp.movies.domain.repository

import com.lamda.trendingmoviesapp.movies.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(): Flow<Movies>
}