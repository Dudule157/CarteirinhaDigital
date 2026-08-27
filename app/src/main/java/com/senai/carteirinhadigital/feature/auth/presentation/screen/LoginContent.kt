package com.senai.carteirinhadigital.feature.auth.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.senai.carteirinhadigital.feature.auth.presentation.LoginEvent
import com.senai.carteirinhadigital.feature.auth.presentation.LoginUiState

@Composable
fun LoginContent (
    modifier: Modifier : Modifier,
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement
            .spacedBy(10.dp, Alignment.CenterVertically),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value
        )
    }
}