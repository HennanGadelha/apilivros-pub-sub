package com.hennangadelha.livro.repository

import com.hennangadelha.livro.model.Livro

interface LivroRepository {

    fun cadastrar(livro: Livro): Livro

}