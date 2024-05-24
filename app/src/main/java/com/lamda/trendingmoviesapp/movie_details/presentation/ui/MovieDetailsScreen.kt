package com.lamda.trendingmoviesapp.movie_details.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.lamda.trendingmoviesapp.ui.theme.Violet30
import com.lamda.trendingmoviesapp.ui.theme.Violet40
import com.lamda.trendingmoviesapp.ui.theme.Violet50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    movieId:String
){
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

            Text(text = movieId)

        }

    }
}