package com.themgi.todo

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = "SPLASH_SCREEN")
    object StartUpScreen : Screen(route = "START_UP_SCREEN")
    object WelcomeScreen : Screen(route = "WELCOME_SCREEN")
    object LoginScreen : Screen(route = "LOGIN_SCREEN")
    object RegisterAccountScreen : Screen(route = "REGISTER_ACCOUNT_SCREEN")
    object TestingATopAppBar : Screen(route = "TESTING_A_TOP_APP_BAR")
}
