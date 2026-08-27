package com.senai.carteirinhadigital.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.auth.presentation.screen.LoginScreen

fun NavGraphBuilder.authScreen(
    navController: NavController
) {
    composable ( Routes.Login ){
        LoginScreen(
            navController = navController
        )
    }
}
