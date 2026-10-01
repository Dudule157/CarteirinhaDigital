package com.senai.carteirinhadigital.feature.unidadecurricular.domain.repository

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}