package com.lamda.trendingmoviesapp.movie_details.data.network.service

import com.lamda.trendingmoviesapp.common.util.Constants
import com.lamda.trendingmoviesapp.common.util.Constants.MOVIE_DETAILS_ARGUMENT_KEY
import com.lamda.trendingmoviesapp.movie_details.data.model.MovieDetailsResult
import com.lamda.trendingmoviesapp.movie_details.data.network.MovieDetailsEndPoints.MOVIE_DETAILS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsService {
    @GET("$MOVIE_DETAILS{$MOVIE_DETAILS_ARGUMENT_KEY}")
    suspend fun getMovieDetails(
        @Path(MOVIE_DETAILS_ARGUMENT_KEY) movieId:Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language : String = "en-US",
    ): Response<MovieDetailsResult>
}