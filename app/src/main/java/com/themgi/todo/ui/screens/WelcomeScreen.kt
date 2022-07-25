package com.themgi.todo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.themgi.todo.R
import com.themgi.todo.Screen
import com.themgi.todo.data.IconData
import com.themgi.todo.ui.components.*

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    Layout {
        IconPrimaryButton(
            iconData = IconData(
                contentDescription = "Arrow Back",
                imageVector = Icons.Default.KeyboardArrowLeft
            )
        ) {
            navHostController.popBackStack()
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HeadlineAndLabel(
                modifier = Modifier.padding(top = 70.dp),
                headlineText = stringResource(id = R.string.welcome),
                labelText = stringResource(
                    id = R.string.login_stmt
                )
            )

            Column {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.login_string).uppercase()
                ) {
                    navHostController.navigate(Screen.LoginScreen.route)
                }
                Spacer(modifier = Modifier.padding(10.dp))
                SecondaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = stringResource(id = R.string.create_account_string).uppercase()
                ) {
                    navHostController.navigate(Screen.RegisterAccountScreen.route)
                }
            }
        }
    }
}