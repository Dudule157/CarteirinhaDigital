package com.senai.carteirinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.feature.home.presentation.component.BotaoNavegacao

@Composable
fun HomeScreen(
    navController: NavController = NavController(
        LocalContext.current
    ),
    modifier: Modifier = Modifier,
    usuarioLogado: UsuarioLogado
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Aluno",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = usuarioLogado.nome,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = usuarioLogado.curso,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = usuarioLogado.turma,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotaoNavegacao(
                "Carteirinha",
                {
                    navController.navigate(Routes.Carteirinha.route)
                },
                modifier = Modifier.fillMaxWidth(.7f)
            )
            BotaoNavegacao(
                "Unidades Curriculares",
                {
                    navController.navigate(Routes.UCAluno.route)
                },
                modifier = Modifier.fillMaxWidth(.7f)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        usuarioLogado = UsuarioLogado(
            id="1",
            nome = "Rafael Costa",
            curso="Desenvolvimento de Sistemas",
            turma = "2DEVEST-A",
            token = "jhhhhhhh"
        )
    )
}