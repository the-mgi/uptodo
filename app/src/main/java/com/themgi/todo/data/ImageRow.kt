package com.themgi.todo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

data class ImageRow(
    val contentDescription: String,
    @DrawableRes val imageResource: Int,
    @StringRes val headLineText: Int,
    @StringRes val labelText: Int
)

data class ImageData(
    val contentDescription: String,
    @DrawableRes val image: Int
)

data class IconData(
    val contentDescription: String,
    val imageVector: ImageVector
)

data class UserLoginData(
    var username: MutableState<String> = mutableStateOf(""),
    var password: MutableState<String> = mutableStateOf("")
)

data class UserRegisterData(
    var username: MutableState<String> = mutableStateOf(""),
    var password: MutableState<String> = mutableStateOf(""),
    var confirmPassword: MutableState<String> = mutableStateOf("")
)