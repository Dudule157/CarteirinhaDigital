package com.senai.carteirinhadigital.feature.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carteirinhadigital.feature.auth.data.repository.FakeLoginRepositoryImpl
import com.senai.carteirinhadigital.feature.auth.data.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository = FakeLoginRepositoryImpl()
): ViewModel(){

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun OnEvent(event: LoginEvent){
        when(event){
            is LoginEvent.OnUsuarioChange -> {
                _uiState.update { state ->
                    state.copy(
                        usuario = event.value,
                        errorMessage = null
                    )
                }
            }
            is LoginEvent.OnSenhaChange -> {
                _uiState.update { state ->
                    state.copy(
                        senha = event.value,
                        errorMessage = null
                    )
                }
            }

            LoginEvent.OnEntrarClick -> fazerLogin()
        }
    }

    private fun fazerLogin() {
        val state = _uiState.value

        if (state.usuario.isBlank() || state.senha.isBlank()){
            _uiState.update {state ->
                state.copy(
                    errorMessage = "Preencha login e senha"
                )
            }
            return
        }
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null,
                    usuarioLogado = null

                )
            }
        }
        val result = repository.login(state.usuario.trim(),
            state.senha.trim())
    }
}