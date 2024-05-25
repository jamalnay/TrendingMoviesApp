package com.lamda.moviedetails.domain.use_cases

import com.lamda.moviedetails.data.model.ResultSet
import com.lamda.moviedetails.domain.model.MovieDetails
import com.lamda.moviedetails.domain.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(
    private val movieDetailsRepository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieId: Int): ResultSet<MovieDetails> = movieDetailsRepository.getMovieDetails(movieId)
}