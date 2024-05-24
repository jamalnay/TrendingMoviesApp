package com.lamda.trendingmoviesapp.movie_details.domain.use_cases

import com.lamda.trendingmoviesapp.movie_details.data.model.ResultSet
import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails
import com.lamda.trendingmoviesapp.movie_details.domain.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(
    private val movieDetailsRepository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieId: Int): ResultSet<MovieDetails> = movieDetailsRepository.getMovieDetails(movieId)
}