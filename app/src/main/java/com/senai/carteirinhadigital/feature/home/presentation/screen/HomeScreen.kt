package com.senai.carteirinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        modifier = Modifier
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { navController.navigate(Routes.Carteirinha)},
        ) {
            Text("Carteirinha")
        }
        Button(
            onClick = { navController.navigate(Routes.UnidadeCurricular)},
        ) {
            Text("Unidade curricular")
        }
    }
}

