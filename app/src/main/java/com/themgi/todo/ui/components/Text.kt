package com.themgi.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HeadlineAndLabel(modifier: Modifier = Modifier, headlineText: String, labelText: String) {
    Column(modifier = modifier) {
        Text(
            text = headlineText,
            style = MaterialTheme.typography.displayLarge,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
        Text(
            text = labelText,
            style = MaterialTheme.typography.labelMedium,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .alpha(0.87f)
        )

    }
}