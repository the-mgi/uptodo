package com.themgi.todo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.themgi.todo.R
import com.themgi.todo.Screen
import com.themgi.todo.data.IconData
import com.themgi.todo.data.ImageData
import com.themgi.todo.data.UserRegisterData
import com.themgi.todo.ui.components.*

@Composable
fun RegisterAccountScreen(navHostController: NavHostController) {
    val userRegisterData by remember {
        mutableStateOf(UserRegisterData())
    }

    Layout {
        Column {
            IconPrimaryButton(
                iconData = IconData(
                    contentDescription = "Arrow Back",
                    imageVector = Icons.Default.KeyboardArrowLeft
                )
            ) {
                navHostController.popBackStack()
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.alpha(0.87f)
            )
            Spacer(modifier = Modifier.padding(top = 40.dp))
            CustomOutlinedTextField(
                textString = stringResource(R.string.username_string),
                value = userRegisterData.username.value,
                placeholderText = stringResource(id = R.string.enter_username),
                onChangeFieldValue = { updatedString ->
                    userRegisterData.username.value = updatedString
                }
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            CustomOutlinedTextField(
                textString = stringResource(R.string.passwod_string),
                value = userRegisterData.password.value,
                placeholderText = "xxxxxxxxxx",
                onChangeFieldValue = { updatedString ->
                    userRegisterData.password.value = updatedString
                },
                isSecuredField = true
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            CustomOutlinedTextField(
                textString = stringResource(R.string.confirm_password),
                value = userRegisterData.confirmPassword.value,
                placeholderText = "xxxxxxxxxx",
                onChangeFieldValue = { updatedString ->
                    userRegisterData.confirmPassword.value = updatedString
                },
                isSecuredField = true
            )
            Spacer(modifier = Modifier.padding(top = 60.dp))
            PrimaryButton(
                text = stringResource(id = R.string.register),
                modifier = Modifier.fillMaxWidth()
            ) {

            }
            Divider(text = stringResource(R.string.or), spacing = 50f)
            SecondaryButton(
                text = stringResource(id = R.string.register_google),
                modifier = Modifier.fillMaxWidth(),
                imageData = ImageData(
                    contentDescription = stringResource(R.string.gogole_logo),
                    image = R.drawable.google__g__logo_svg
                )
            ) {

            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            SecondaryButton(
                text = stringResource(id = R.string.register_apple),
                modifier = Modifier.fillMaxWidth(),
                imageData = ImageData(
                    contentDescription = stringResource(R.string.apple_logo),
                    image = R.drawable.apple
                )
            ) {

            }

        }

        Text(
            buildAnnotatedString {
                append(stringResource(R.string.already_have_account) + " ")
                withStyle(style = SpanStyle(color = Color.White.copy(alpha = 0.7f))) {
                    append(" " + stringResource(R.string.login_now))
                }
            },
            style = MaterialTheme.typography.labelSmall, modifier = Modifier
                .alpha(0.87f)
                .align(Alignment.BottomCenter)
                .clickable { navHostController.navigate(Screen.LoginScreen.route) },
            fontSize = 14.sp
        )
    }
}