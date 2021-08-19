package com.hennangadelha.livros.service

import com.hennangadelha.infra.LivroNatsClient
import com.hennangadelha.livros.models.Livro
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(private val livroClient: LivroNatsClient) : LivroService  {

    override fun cadastrar(livro: Livro) : Livro {
        livroClient.send(livro)
        return livro

    }


}