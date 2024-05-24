package com.lamda.trendingmoviesapp.movies.di

import com.lamda.trendingmoviesapp.movies.data.network.service.MoviesService
import com.lamda.trendingmoviesapp.movies.data.repository.MoviesRepositoryImpl
import com.lamda.trendingmoviesapp.movies.domain.repository.MoviesRepository
import com.lamda.trendingmoviesapp.movies.domain.use_cases.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {
    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)

    @Singleton
    @Provides
    fun provideMoviesRepository(api:MoviesService): MoviesRepository = MoviesRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository) = GetMoviesUseCase(repository)

}