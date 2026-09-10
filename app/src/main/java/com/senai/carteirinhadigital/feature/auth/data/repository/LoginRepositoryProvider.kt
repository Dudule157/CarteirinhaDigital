package com.senai.carteirinhadigital.feature.auth.data.repository

import com.senai.carteirinhadigital.feature.auth.data.remote.network.NetworkFactory

object LoginRepositoryProvider {
    private const val USE_FAKE_REPOSITORY = false

    fun provide(): LoginRepository {
        return if (USE_FAKE_REPOSITORY) {
            FakeLoginRepositoryImpl()
        } else {
            ApiAuthRepositoryImpl(NetworkFactory.createAuthApi())
        }
    }
}