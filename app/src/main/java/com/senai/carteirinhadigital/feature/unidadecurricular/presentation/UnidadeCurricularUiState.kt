package com.senai.carteirinhadigital.feature.unidadecurricular.presentation

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}