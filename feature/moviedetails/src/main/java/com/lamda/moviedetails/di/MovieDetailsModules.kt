package com.lamda.moviedetails.di

import com.lamda.moviedetails.data.network.service.MovieDetailsService
import com.lamda.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.lamda.moviedetails.domain.repository.MovieDetailsRepository
import com.lamda.moviedetails.domain.use_cases.GetMovieDetailsUseCase
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
    fun provideMoviesRepository(api: MovieDetailsService): MovieDetailsRepository
    = MovieDetailsRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MovieDetailsRepository)
    = GetMovieDetailsUseCase(repository)

}