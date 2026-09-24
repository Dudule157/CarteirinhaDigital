package com.senai.carteirinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.di.AppContainer
import com.senai.carteirinhadigital.app.session.SessionViewModel
import com.senai.carteirinhadigital.feature.auth.presentation.screen.LoginScreen
import com.senai.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaScreen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carteirinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularViewModel
import com.senai.carteirinhadigital.feature.unidadecurricular.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carteirinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel(),
    container: AppContainer,
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()
    val usuario = usuarioLogado

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {

            LoginScreen(
                navController = navController,
                onLoginSucesso = { usuario ->
                    container.authTokenStore.setToken(usuario.token)
                    sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.HomeAluno.route)
                }
            )
        }

        composable(Routes.Carteirinha.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

        composable(Routes.HomeAluno.route) {

            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        composable(Routes.UCAluno.route) {

            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }

            } else {
                val unidadeCurricularFactory = remember(
                    container.unidadeCurricularRepository
                ) {
                    UnidadeCurricularViewModelFactory(
                        repository = container.unidadeCurricularRepository
                    )
                }

                val unidadeCurricularViewModel: UnidadeCurricularViewModel = viewModel(
                    factory = unidadeCurricularFactory
                )
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    UnidadeCurricularScreen(
                        modifier =Modifier.padding(innerPadding),
                        viewModel =unidadeCurricularViewModel
                    )
                }
            }
        }
    }
}