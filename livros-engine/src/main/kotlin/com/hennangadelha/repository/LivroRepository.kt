package com.hennangadelha.repository

import com.hennangadelha.model.Livro
import java.util.*

interface LivroRepository {

    fun listarTodos(): List<Livro>

    fun buscarPorId(id: UUID) : Livro

}