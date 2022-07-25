package com.themgi.todo.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Divider(text: String? = null, spacing: Float = 40f) {
    Row {
        Box(
            modifier = Modifier
                .padding(top = spacing.dp, bottom = spacing.dp)
                .fillMaxWidth(0.45f)
                .border(1.dp, Color(0xFF979797))
                .height(1.dp)
        )
        if (text != null) Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.2f)
                .align(Alignment.CenterVertically)
        )
        Box(
            modifier = Modifier
                .padding(top = spacing.dp, bottom = spacing.dp)
                .fillMaxWidth(1f)
                .border(1.dp, Color(0xFF979797))
                .height(1.dp)
        )
    }

}