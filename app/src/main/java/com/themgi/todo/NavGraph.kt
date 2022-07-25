package com.themgi.todo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themgi.todo.ui.screens.*

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) { UpTodoSplashScreen(navHostController = navHostController) }
        composable(route = Screen.StartUpScreen.route) { StartUpScreen(navHostController = navHostController) }
        composable(route = Screen.WelcomeScreen.route) { WelcomeScreen(navHostController = navHostController) }
        composable(route = Screen.LoginScreen.route) { LoginScreen(navHostController = navHostController) }
        composable(route = Screen.RegisterAccountScreen.route) {
            RegisterAccountScreen(
                navHostController = navHostController
            )
        }
        composable(route = Screen.TestingATopAppBar.route) {
            TopAppBarTestingScreen(
                navHostController = navHostController
            )
        }
    }
}