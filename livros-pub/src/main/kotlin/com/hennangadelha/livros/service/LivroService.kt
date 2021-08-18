package com.hennangadelha.livros.service

import com.hennangadelha.livros.models.Livro
import javax.inject.Singleton

@Singleton
interface LivroService {

    fun cadastrar(livro: Livro): Livro

}