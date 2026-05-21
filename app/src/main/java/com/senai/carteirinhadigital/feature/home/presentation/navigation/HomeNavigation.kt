package com.senai.carteirinhadigital.feature.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.auth.presentation.LoginScreen

fun NavGraphBuilder.homeScreen(
    navController: NavController
) {
    composable ( Routes.HomeScreen){
        LoginScreen(
            navController = navController
        )
    }
}