package com.senai.carteirinhadigital.app.di

import com.senai.carteirinhadigital.core.auth.AuthTokenStore
import com.senai.carteirinhadigital.feature.auth.data.repository.LoginRepository
import com.senai.carteirinhadigital.feature.unidadecurricular.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}