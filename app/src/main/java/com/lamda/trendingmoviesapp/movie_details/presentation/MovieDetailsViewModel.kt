package com.lamda.trendingmoviesapp.movie_details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamda.trendingmoviesapp.movie_details.data.model.ResultSet
import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails
import com.lamda.trendingmoviesapp.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
): ViewModel() {

    private val _movie = MutableStateFlow<ResultSet<MovieDetails>>(ResultSet.Loading)
    val movie: StateFlow<ResultSet<MovieDetails>> = _movie.asStateFlow()
    fun getMovieDetails(movieId:Int){
        viewModelScope.launch {
            _movie.value = getMovieDetailsUseCase.invoke(movieId)
        }
    }

}