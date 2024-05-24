package com.lamda.trendingmoviesapp.movies.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lamda.trendingmoviesapp.R
import com.lamda.trendingmoviesapp.common.util.Constants
import com.lamda.trendingmoviesapp.movies.domain.model.Movie

@Composable
fun MovieItem(
    movie: Movie,
    onClick:(id:Int) -> Unit
) {
    val context = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp,pressedElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(movie.id) },
    ){
        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(Constants.POSTERS_BASE_URL.plus(movie.posterPath))
                .crossfade(true)
                .build(),
            contentDescription = movie.title,
            modifier = Modifier.height(280.dp),
            contentScale = ContentScale.Crop,
            error = painterResource(id = R.drawable.error_place_holder),
            placeholder = painterResource(id = R.drawable.image_place_holder)
        )
        Text(
            text = movie.title,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}