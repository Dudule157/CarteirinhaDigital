package com.senai.carteirinhadigital.feature.unidadecurricular.data

import com.senai.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import kotlin.String

fun dataSource(): List<UnidadeCurricular> {
    return listOf(
        UnidadeCurricular( id = "1",nome = "Matemática",professor = "Eistein",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "2",nome = "Português",professor = "Heloísa",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "3",nome = "História",professor = "Amer",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "4",nome = "Educação Fisica",professor = "Eduardo",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "5",nome = "Orientação de Matamática",professor = "Ricardo",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "7",nome = "Orientação de Português",professor = "Diana",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1),
        UnidadeCurricular( id = "7",nome = "Inglês",professor = "Maria",nota1 = 7.8,nota2 = 8.5,media = 7.0,faltas = 1)
    )
}
