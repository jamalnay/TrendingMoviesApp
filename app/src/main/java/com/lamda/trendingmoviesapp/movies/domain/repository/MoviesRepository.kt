package com.lamda.trendingmoviesapp.movies.domain.repository

import androidx.paging.PagingData
import com.lamda.trendingmoviesapp.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(): Flow<PagingData<Movie>>
}