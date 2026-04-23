package com.senai.carteirinhadigital.feature.carteirinha.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaScreen

fun NavGraphBuilder.carteirinhaScreen(
    onNavigateToLogin: () -> Unit
) {
    composable (Routes.Carteirinha) {
        CarteirinhaScreen(
        onBackClick = onNavigateToLogin) }
}