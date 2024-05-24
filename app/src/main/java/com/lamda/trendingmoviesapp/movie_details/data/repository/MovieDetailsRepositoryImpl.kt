package com.lamda.trendingmoviesapp.movie_details.data.repository

import com.lamda.trendingmoviesapp.movie_details.data.model.ResultSet
import com.lamda.trendingmoviesapp.movie_details.data.model.toMovieDetails
import com.lamda.trendingmoviesapp.movie_details.data.network.service.MovieDetailsService
import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails
import com.lamda.trendingmoviesapp.movie_details.domain.repository.MovieDetailsRepository
import java.net.HttpURLConnection

class MovieDetailsRepositoryImpl(
    private val movieDetailsApi:MovieDetailsService
):MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: Int): ResultSet<MovieDetails> {
        try {
            val response = movieDetailsApi.getMovieDetails(movieId)
            if (response.isSuccessful) {
                val result = response.body()!!.toMovieDetails()
                return ResultSet.Success(result)
            } else {
                return when (response.code()) {
                    HttpURLConnection.HTTP_NOT_FOUND -> {
                        ResultSet.Error(
                            null,
                            errorMsg = "Movie not found.",
                            code = response.code()
                        )
                    }
                    else -> {
                        ResultSet.Error(
                            null,
                            errorMsg = "Unexpected error",
                            code = response.code()
                        )
                    }
                }
            }
        }catch (e: Exception) {
            return ResultSet.Error(e, e.message, null)
        }
    }

}