package com.senai.carteirinhadigital.feature.unidadecurricular.data.remote.dto

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

class UnidadeCurricularDTO(
    val id: String,
    val nome: String,
    val professor: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val faltas: Int
) {
    fun toDomain(): UnidadeCurricular {
        return UnidadeCurricular(
            id = id,
            nome = nome,
            professor = professor,
            nota1 = nota1,
            nota2 = nota2,
            media = media,
            faltas =faltas
        )
    }
}