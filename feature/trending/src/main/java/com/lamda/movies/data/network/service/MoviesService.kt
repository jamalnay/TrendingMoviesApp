package com.lamda.movies.data.network.service

import com.lamda.util.Constants.API_KEY
import com.lamda.movies.data.model.MoviesResult
import com.lamda.movies.data.network.MoviesEndPoints.TRENDING_MOVIES
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MoviesService {
    @GET(TRENDING_MOVIES)
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult : Boolean = false,
        @Query("include_video") includeVideo : Boolean = false,
        @Query("language") language : String = "en-US",
        @Query("sort_by") popularity : String = "popularity.desc",
        @Query("page") page : Int = 1,
    ): MoviesResult
}