package com.lamda.trendingmoviesapp.movies.presentation

import androidx.lifecycle.ViewModel
import com.lamda.trendingmoviesapp.movies.domain.use_cases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {
    fun getMovies() = getMoviesUseCase()
}