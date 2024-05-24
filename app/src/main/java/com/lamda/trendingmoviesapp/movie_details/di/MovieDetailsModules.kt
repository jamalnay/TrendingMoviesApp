package com.lamda.trendingmoviesapp.movie_details.di

import com.lamda.trendingmoviesapp.movie_details.data.network.service.MovieDetailsService
import com.lamda.trendingmoviesapp.movie_details.data.repository.MovieDetailsRepositoryImpl
import com.lamda.trendingmoviesapp.movie_details.domain.repository.MovieDetailsRepository
import com.lamda.trendingmoviesapp.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsModules {
    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): MovieDetailsService
    = retrofit.create(MovieDetailsService::class.java)

    @Singleton
    @Provides
    fun provideMoviesRepository(api:MovieDetailsService): MovieDetailsRepository
    = MovieDetailsRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MovieDetailsRepository)
    = GetMovieDetailsUseCase(repository)

}