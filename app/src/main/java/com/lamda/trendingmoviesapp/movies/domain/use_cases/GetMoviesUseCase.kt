package com.lamda.trendingmoviesapp.movies.domain.use_cases

import com.lamda.trendingmoviesapp.movies.domain.repository.MoviesRepository

class GetMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() = moviesRepository.getMovies()
}