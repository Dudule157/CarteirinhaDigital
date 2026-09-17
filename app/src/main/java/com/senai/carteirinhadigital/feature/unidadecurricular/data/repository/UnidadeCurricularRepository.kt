package com.senai.carteirinhadigital.feature.unidadecurricular.data.repository

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular


interface UnidadeCurricularRepository {
    suspend fun listarUnidades(
        token: String
    ): Result<List<UnidadeCurricular>>
}