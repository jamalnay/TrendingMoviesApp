package com.lamda.movies.domain.use_cases

import com.lamda.movies.domain.repository.MoviesRepository

class GetMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() = moviesRepository.getMovies()
}