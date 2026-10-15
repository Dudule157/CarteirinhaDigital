package com.senai.carteirinhadigital.app.di

import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.core.network.NetworkClient
import com.senai.carteirinhadigital.feature.auth.data.remote.service.AuthApi
import com.senai.carteirinhadigital.feature.auth.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinhadigital.feature.auth.data.repository.FakeAuthRepository
import com.senai.carteirinhadigital.feature.auth.domain.repository.LoginRepository
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import kotlin.jvm.java

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(
        baseUrl = BASE_URL,
        sessionTokenStore = sessionTokenStore
    )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }

    private val unidadeCurricularApi: com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(_root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }
    override val unidadeCurricularRepository: com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository by lazy {
        _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.repository.ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}