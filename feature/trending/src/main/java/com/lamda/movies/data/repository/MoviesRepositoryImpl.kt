package com.lamda.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lamda.movies.data.MoviesDataSource
import com.lamda.movies.data.network.service.MoviesService
import com.lamda.movies.domain.model.Movie
import com.lamda.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

internal class MoviesRepositoryImpl(
    private val moviesApi: MoviesService
): MoviesRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesDataSource(moviesApi) }
        ).flow.flowOn(Dispatchers.IO)
    }
}