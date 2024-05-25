package com.lamda.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import com.lamda.ui.theme.Purple50

@Composable
fun LoadingError(
    modifier: Modifier = Modifier,
    errorMsg:String,
    onRetry: () -> Unit
){
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMsg,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            style = MaterialTheme.typography.titleSmall
        )
        Button(
            onClick = { onRetry() },
            colors = ButtonDefaults.buttonColors(containerColor = Purple50)
        ){
            Text(
                text = "Retry",
                modifier = Modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge)
        }
    }
}