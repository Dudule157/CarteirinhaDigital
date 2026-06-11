package com.senai.carteirinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senai.carteirinhadigital.app.navigation.Routes

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Seja bem-vindo!",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Carteirinha Digital",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Selecione uma opção",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = { navController.navigate(Routes.Carteirinha) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Carteirinha")
        }

        Button(
            onClick = { navController.navigate(Routes.UnidadeCurricular) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Text("Unidade Curricular")
        }
    }
}