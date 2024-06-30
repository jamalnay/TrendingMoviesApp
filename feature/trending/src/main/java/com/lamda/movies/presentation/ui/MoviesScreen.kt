package com.lamda.movies.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.lamda.movies.presentation.MoviesViewModel
import com.lamda.ui.components.LoadingIndicator
import com.lamda.movies.presentation.ui.components.MovieItem
import com.lamda.ui.components.LoadingError
import com.lamda.ui.theme.Violet30
import com.lamda.ui.theme.Violet40
import com.lamda.ui.theme.Violet50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(
    onMovieClick: (Int) -> Unit
){
    val viewModel = hiltViewModel<MoviesViewModel>()
    val movies = viewModel.movies.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
            title = { Text(text = "Trending Movies",color = Color.White) }
        )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        listOf(Violet30, Violet40, Violet50),
                        start = Offset(0f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    )
                )
                .fillMaxSize()
                .padding(
                    start = 4.dp,
                    top = paddingValues.calculateTopPadding(),
                    end = 4.dp,
                    bottom = paddingValues.calculateBottomPadding()
                )
        ){

            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = StaggeredGridCells.Adaptive(180.dp),
                verticalItemSpacing = 12.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(movies.itemCount){ index->
                    movies[index]?.let {
                        MovieItem(
                            movie = it
                        ) { movieId ->
                            onMovieClick(movieId)

                        }
                    }
                }
                item(
                    span = StaggeredGridItemSpan.FullLine
                ) {
                    when (val loadState = movies.loadState.refresh) {
                        is LoadState.Error -> {
                            LoadingError(
                                errorMsg = loadState.error.message ?: "Loading error"
                            ) {
                                movies.retry()
                            }
                        }
                        is LoadState.Loading -> {
                            LoadingIndicator(modifier = Modifier.fillMaxWidth())
                        }
                        else -> {
                            LoadingError(
                                errorMsg = "Unexpected error"
                            ) {
                                movies.retry()
                            }
                        }
                    }
                }
            }
        }
    }
}


