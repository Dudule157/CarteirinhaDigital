package com.senai.carteirinhadigital.feature.unidadecurricular.data.repository

import com.senai.carteirinhadigital.feature.auth.data.remote.network.NetworkFactory

object UnidadeCurricularRepositoryProvider {
    fun provide(): UnidadeCurricularRepository{
        return ApiUnidadeCurricularRepositoryImpl(
            NetworkFactory.createUnidadeCurricularApi()
        )
    }
}