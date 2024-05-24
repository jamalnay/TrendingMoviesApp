package com.lamda.trendingmoviesapp.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lamda.trendingmoviesapp.movies.data.MoviesDataSource
import com.lamda.trendingmoviesapp.movies.data.network.service.MoviesService
import com.lamda.trendingmoviesapp.movies.domain.model.Movie
import com.lamda.trendingmoviesapp.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(
    private val moviesApi: MoviesService
): MoviesRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesDataSource(moviesApi) }
        ).flow
    }
}