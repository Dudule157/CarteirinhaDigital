package com.senai.carteirinhadigital.app

import androidx.compose.runtime.Composable
import com.senai.carteirinhadigital.app.navigation.AppNavHost
import com.senai.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App() {
    CarteirinhaDigitalTheme {
        AppNavHost()
    }
}