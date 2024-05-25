package com.lamda.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lamda.ui.theme.Violet20
import com.lamda.ui.theme.VioletGrey80

@Composable
fun GenreShip(
    modifier: Modifier = Modifier,
    genreName: String,
){
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = VioletGrey80
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Violet20)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            text = genreName,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}