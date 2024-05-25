package com.lamda.movies.domain.repository

import androidx.paging.PagingData
import com.lamda.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(): Flow<PagingData<Movie>>
}