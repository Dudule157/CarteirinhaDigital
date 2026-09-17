package com.senai.carteirinhadigital.feature.unidadecurricular.presentation

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState (
    val isLoading: Boolean = false,
    val listaUnidades: List<UnidadeCurricular> = emptyList(),
    val errorMensage : String? = null
){}