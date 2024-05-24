package com.lamda.trendingmoviesapp.movie_details.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lamda.trendingmoviesapp.R
import com.lamda.trendingmoviesapp.common.presentation.ui.components.LoadingError
import com.lamda.trendingmoviesapp.common.presentation.ui.components.LoadingIndicator
import com.lamda.trendingmoviesapp.common.util.Constants
import com.lamda.trendingmoviesapp.movie_details.data.model.ResultSet
import com.lamda.trendingmoviesapp.movie_details.domain.model.MovieDetails
import com.lamda.trendingmoviesapp.movie_details.presentation.MovieDetailsViewModel
import com.lamda.trendingmoviesapp.ui.theme.Violet20
import com.lamda.trendingmoviesapp.ui.theme.VioletGrey80
import com.lamda.trendingmoviesapp.ui.theme.Yellow40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    movieId: String,
    onBackPress: () -> Unit
){
    val viewModel: MovieDetailsViewModel = hiltViewModel()
    viewModel.getMovieDetails(movieId.toInt())
    val movie = viewModel.movie.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
            title = { Text(text = "",color = Color.White) },
            navigationIcon = { IconButton(
                modifier = Modifier.padding(start = 12.dp,top = 16.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xAA000000)),
                onClick = { onBackPress()}
            ) {
                Icon(
                    painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                    contentDescription = "back button",
                    tint = Color.White
                )
            }}
        )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .background(
                    Color.Black
                )
                .fillMaxSize()
                .padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = paddingValues.calculateBottomPadding()
                )
        ){
            when (movie.value){
                is ResultSet.Error -> {
                    val error = (movie.value as ResultSet.Error)
                    LoadingError(
                        modifier = Modifier.padding(top = paddingValues.calculateTopPadding()+32.dp),
                        errorMsg = error.errorMsg.toString()
                    ){
                        viewModel.getMovieDetails(movieId.toInt())
                    }
                }
                is ResultSet.Loading ->
                    LoadingIndicator(
                        Modifier
                        .fillMaxWidth()
                        .padding(top = paddingValues.calculateTopPadding() + 32.dp))
                is ResultSet.Success -> {
                    val data = (movie.value as ResultSet.Success<MovieDetails>).data
                    MovieDetailsMainScreen(movie = data!!)
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieDetailsMainScreen(movie:MovieDetails){
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest
            .Builder(context)
            .data(Constants.POSTERS_BASE_URL.plus(movie.posterPath))
            .crossfade(true)
            .build(),
        contentDescription = movie.title,
        modifier = Modifier
            .height(480.dp)
            .fillMaxWidth()
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    endY = size.height - (size.height / 4)
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            },
        contentScale = ContentScale.FillWidth,
        error = painterResource(id = R.drawable.error_place_holder),
        placeholder = painterResource(id = R.drawable.image_place_holder)
    )
    Column(
        modifier = Modifier
            .offset(y = (-120).dp)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(4/7f),
                text = movie.title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Card(
                modifier = Modifier.padding(end = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Yellow40, contentColor = Color.Black),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                    text = "IMDB " + movie.voteAverage.toString().take(3),
                    style = MaterialTheme.typography.labelSmall
                )
            }

        }
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = "Release date: ",
                style = MaterialTheme.typography.labelMedium,
                color = VioletGrey80
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = movie.releaseDate,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        FlowRow(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            movie.genres.forEach {genre->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent,
                        contentColor = VioletGrey80
                    ),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(2.dp, Violet20)
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                        text = genre.name,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = movie.overview,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}