package com.lamda.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamda.ui.theme.Yellow40

@Composable
fun ImdbRatingCard(
    modifier: Modifier = Modifier,
    rating: Double,
){
    Card(
        modifier = modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Yellow40, contentColor = Color.Black),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
            text = "IMDB " + rating.toString().take(3),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Composable
fun ImdbRatingCardPreview() {
    ImdbRatingCard(rating = 7.45)
}