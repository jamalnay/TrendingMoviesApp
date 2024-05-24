package com.lamda.trendingmoviesapp.movies.data.network.service

import com.lamda.trendingmoviesapp.common.util.Constants.API_KEY
import com.lamda.trendingmoviesapp.movies.data.model.MoviesResult
import com.lamda.trendingmoviesapp.movies.data.network.MoviesEndPoints.TRENDING_MOVIES
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET(TRENDING_MOVIES)
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult : Boolean = false,
        @Query("include_video") includeVideo : Boolean = false,
        @Query("language") language : String = "en-US",
        @Query("sort_by") popularity : String = "popularity.desc",
        @Query("page") page : Int = 1,
    ):MoviesResult
}