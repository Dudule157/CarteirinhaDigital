package com.senai.carteirinhadigital.feature.professor.turmas.data.repository

import com.senai.carteirinhadigital.feature.professor.turma.domain.model.Turma
import com.senai.carteirinhadigital.feature.professor.turmas.data.remote.service.TurmaProfessorApi
import com.senai.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaProfessorRepository
import okio.IOException
import retrofit2.HttpException
import kotlin.collections.map
import kotlin.recoverCatching
import kotlin.runCatching

class ApiTurmaProfessorRepositoryImpl(
    private val api: TurmaProfessorApi
) : TurmaProfessorRepository {
    override suspend fun listarMinhasTurmas(): Result<List<Turma>> = runCatching {
        api.listarMinhasTurmas().map { it.toDomain() }
    }.recoverCatching { error ->
        throw when (error) {
            is HttpException -> if (error.code() == 401) {
                kotlin.IllegalStateException("Sua sessão expirou. Faça login novamente.")
            } else {
                kotlin.IllegalStateException("Erro ao carregar turmas (${error.code()}).")
            }
            is IOException -> kotlin.IllegalStateException("Não foi possível conectar à API.")
            else -> kotlin.IllegalStateException(error.message ?: "Erro ao carregar turmas.")
        }
    }
}
