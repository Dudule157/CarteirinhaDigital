package com.senai.carteirinhadigital.feature.auth.presentation

import android.R.attr.label
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senai.carteirinhadigital.R
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                navController: NavController,
                ) {
    var login by remember { mutableStateOf("") };
    var erroLogin by remember { mutableStateOf(false) };
    var mensagemLogin by remember { mutableStateOf("email") };
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.senai),
            contentDescription = null,
        )

        Text("Login")
        TextField(
            value = login,
            onValueChange = {login = it
                            erroLogin = false},
            label = { Text(mensagemLogin) },
            isError = erroLogin,
        )

        var senha by remember { mutableStateOf("") };
        var erroSenha by remember { mutableStateOf(false) };
        var mensagemSenha by remember { mutableStateOf("senha") };
        OutlinedTextField(
            value = senha,
            onValueChange = {senha = it
                erroSenha = false},
            label = { Text(mensagemSenha) },
            isError = erroSenha,
        )
        Button(
            onClick = {
                if (login == "eduardo" && senha == "1234")   {
                    navController.navigate(Routes.Carteirinha)
                    erroLogin = false
                    erroSenha = false
            } else if(senha != "1234") {
                erroSenha = true
                    mensagemSenha = "Senha incorreta"
            } else if(login != "eduardo") {
                erroLogin = true
                    mensagemLogin = "Login incorreto"
            } else{
                erroSenha = true
                    erroLogin = true
                    mensagemLogin = "Login incorreto"
                    mensagemSenha = "Senha incorreta"
            }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .width(200.dp),
            shape = RoundedCornerShape(size = 2.dp),
            border = BorderStroke(
                width = 4.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ){
            Text("Entrar")
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginScreenPreview() {
    CarteirinhaDigitalTheme() {
      //  LoginScreen()
    }

}