package com.senai.carteirinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.senai.carteirinhadigital.feature.unidadecurricular.data.dataSource

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier
) {
    val unidadesCurriculares = dataSource()

    UnidadeCurricularContent(
        unidadesCurriculares = unidadesCurriculares
    )
}