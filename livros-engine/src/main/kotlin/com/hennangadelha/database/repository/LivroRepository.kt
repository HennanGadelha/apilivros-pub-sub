package com.hennangadelha.database.repository

import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import java.util.*

interface LivroRepository {

    fun listarTodos(): List<LivroEntity>

    fun buscarPorId(id: UUID) : Livro

}