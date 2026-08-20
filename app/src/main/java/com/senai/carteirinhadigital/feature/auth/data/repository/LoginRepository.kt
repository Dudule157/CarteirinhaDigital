package com.senai.carteirinhadigital.feature.auth.data.repository

import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(usuario: String, senha: String) : Result<UsuarioLogado>

}