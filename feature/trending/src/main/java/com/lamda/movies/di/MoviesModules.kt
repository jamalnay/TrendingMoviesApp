package com.lamda.movies.di

import com.lamda.movies.data.network.service.MoviesService
import com.lamda.movies.data.repository.MoviesRepositoryImpl
import com.lamda.movies.domain.repository.MoviesRepository
import com.lamda.movies.domain.use_cases.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MoviesModules {
    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)

    @Singleton
    @Provides
    fun provideMoviesRepository(api: MoviesService): MoviesRepository = MoviesRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository) = GetMoviesUseCase(repository)

}