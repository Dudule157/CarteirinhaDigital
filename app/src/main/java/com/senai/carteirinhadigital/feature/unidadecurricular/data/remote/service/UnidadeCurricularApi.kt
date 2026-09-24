package com.senai.carteirinhadigital.feature.unidadecurricular.data.remote.service

import com.senai.carteirinhadigital.feature.unidadecurricular.data.remote.dto.UnidadeCurricularDTO
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listarUnidadesCurriculares():
            List<UnidadeCurricularDTO>
}