package com.hennangadelha.livros.service

import com.hennangadelha.infra.LivroNatsClient
import com.hennangadelha.livros.models.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(private val livroClient: LivroNatsClient) : LivroService  {

    override fun cadastrar(livro: Livro) : Livro {
        livroClient.send(livro)
        return livro

    }

    override fun alterar(id: String, livro: Livro) : Livro {
        livroClient.alterar( Pair(id,livro))
        return livro
    }

    override fun delete(id: String) {
        livroClient.delete(id)
    }


}