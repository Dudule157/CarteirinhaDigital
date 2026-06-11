package com.senai.carteirinhadigital.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinhadigital.feature.auth.navigation.authScreen
import com.senai.carteirinhadigital.feature.carteirinha.navigation.carteirinhaScreen
import com.senai.carteirinhadigital.feature.home.presentation.navigation.homeScreen
import com.senai.carteirinhadigital.feature.unidadecurricular.navigation.unidadeCurricularScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        authScreen(
            navController
        )

        carteirinhaScreen(
            onNavigateToLogin = {
                navController.navigate(Routes.Login)
            }
        )

        homeScreen(
            navController
        )

        unidadeCurricularScreen(
            onNavigateToLogin = {
                navController.navigate(Routes.Login)
            }
        )
    }
}