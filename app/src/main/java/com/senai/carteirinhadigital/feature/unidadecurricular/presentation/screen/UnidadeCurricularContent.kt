package com.senai.carteirinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import com.senai.carteirinhadigital.feature.unidadecurricular.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularContent(
    modifier: Modifier = Modifier,
    unidadesCurriculares: List<UnidadeCurricular>
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(unidadesCurriculares) { unidadeCurricular -> UnidadeCurricularCard(unidadeCurricular = unidadeCurricular) }
    }
}
@Preview(showBackground = true,
    showSystemUi = true) @Composable
fun UnidadeCurricularContentPreview() {
    UnidadeCurricularContent(unidadesCurriculares = listOf(
        UnidadeCurricular(
            id = "1",
            nome = "Matemática",
            professor = "João",
            nota1 = 7.8,
            nota2 = 8.5,
            media = 7.0,
            faltas = 1
        )))}
