package com.lamda.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lamda.movies.domain.model.Movie
import com.lamda.movies.domain.use_cases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

    private val _movies = MutableStateFlow<PagingData<Movie>>(PagingData.empty())
    val movies = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            getMoviesUseCase().cachedIn(viewModelScope).collect{
                _movies.value = it
            }
        }
    }

}