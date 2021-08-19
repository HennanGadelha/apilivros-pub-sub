package com.hennangadelha.livro.repository

import com.hennangadelha.livro.model.Livro
import java.util.*

interface LivroRepository {

    fun cadastrar(livro: Livro): Livro

    fun alterar(id: String, livro: Livro) : Livro

    fun deletar(id: String)

}