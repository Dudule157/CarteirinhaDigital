package com.senai.carteirinhadigital.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinhadigital.app.di.AppContainer
import com.senai.carteirinhadigital.app.navigation.AppNavHost
import com.senai.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App(container: AppContainer) {
    CarteirinhaDigitalTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            container= container
        )
    }
}