package com.senai.carteirinhadigital.feature.unidadecurricular.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

fun NavGraphBuilder.unidadeCurricularScreen(
    onNavigateToLogin: () -> Unit
) {
    composable (Routes.UnidadeCurricular) {
        UnidadeCurricularScreen(
        )
    }
}