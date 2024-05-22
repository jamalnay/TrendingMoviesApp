package com.lamda.trendingmoviesapp.movie_details.domain.use_cases

import com.lamda.trendingmoviesapp.movie_details.domain.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(
    private val movieDetailsRepository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieId: Int) = movieDetailsRepository.getMovieDetails(movieId)
}