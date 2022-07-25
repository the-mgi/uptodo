package com.themgi.todo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.themgi.todo.R

@Composable
fun CustomOutlinedTextField(
    textString: String? = null,
    placeholderText: String,
    isSecuredField: Boolean = false,
    value: String = "",
    onChangeFieldValue: (String) -> Unit
) {
    var isPasswordVisible by remember {
        mutableStateOf(true)
    }

    if (null != textString) {
        Text(
            text = textString,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.alpha(0.87f)
        )
    }
    Spacer(modifier = Modifier.padding(top = 8.dp))
    OutlinedTextField(
        value = value, onValueChange = onChangeFieldValue,
        placeholder = {
            Text(
                text = placeholderText,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.lato_regular)),
                    fontSize = 16.sp
                )
            )
        },
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFF979797),
            focusedBorderColor = Color(0xFF979797),
            containerColor = Color(0xFF1D1D1D),
            placeholderColor = Color(0xFF535353),
            textColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        singleLine = true,
        maxLines = 1,
        visualTransformation = if (isSecuredField && isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isSecuredField) {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    if (isPasswordVisible) Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_visibility_off_24),
                        contentDescription = "Visibility Off Icon"
                    ) else Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                        contentDescription = "Visibility Icon"
                    )
                }
            }
        },
    )
}