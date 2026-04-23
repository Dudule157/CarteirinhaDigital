package com.senai.carteirinhadigital.feature.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.auth.presentation.LoginScreen

fun NavGraphBuilder.authScreen(
    onNavigateToCarteirinha: () -> Unit
) {
    composable ( Routes.Login ){
        LoginScreen(
            onLoginClick = onNavigateToCarteirinha
        )
    }
}