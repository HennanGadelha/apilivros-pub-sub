package com.hennangadelha.livros.service

import com.hennangadelha.livros.models.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroService {

    fun cadastrar(livro: Livro): Livro

    fun alterar(id: String,  livro: Livro) : Livro

    fun delete(id: String)



}