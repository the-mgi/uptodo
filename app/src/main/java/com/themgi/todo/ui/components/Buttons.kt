package com.themgi.todo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.themgi.todo.data.IconData
import com.themgi.todo.data.ImageData

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.50f)
        ),
        enabled = enabled,
        modifier = modifier.height(48.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Text(text = text, color = Color.White, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    imageVector: ImageVector? = null,
    imageData: ImageData? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .height(48.dp)
            .border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                shape = MaterialTheme.shapes.large
            ),
        shape = MaterialTheme.shapes.large
    ) {
        if (null != imageData) {
            Image(
                painter = painterResource(id = imageData.image),
                contentDescription = imageData.contentDescription,
                modifier = Modifier.fillMaxHeight(0.7f)
                    .padding(end = 10.dp)
            )
        }
        Text(text = text, color = Color.White, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun TextPrimaryButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            modifier = modifier.alpha(0.44f),
            color = Color.White,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Composable
fun IconPrimaryButton(
    modifier: Modifier = Modifier,
    iconData: IconData,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = iconData.imageVector,
            contentDescription = iconData.contentDescription,
            tint = Color.White
        )
    }
}