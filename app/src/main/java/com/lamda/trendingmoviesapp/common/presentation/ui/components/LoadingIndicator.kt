package com.lamda.trendingmoviesapp.common.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lamda.trendingmoviesapp.ui.theme.Purple50
import com.lamda.trendingmoviesapp.ui.theme.VioletGrey60

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(28.dp),
            color = Purple50,
            trackColor = VioletGrey60,
        )
    }
}