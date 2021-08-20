package com.hennangadelha.livros.service

import com.hennangadelha.infra.LivroNatsClient
import com.hennangadelha.livros.models.Livro
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(private val livroClient: LivroNatsClient) : LivroService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun cadastrar(livro: Livro): Livro {
        livroClient.send(livro)
        logger.info("Enviando livro ao broken: ${livro.toString()}")
        return livro

    }

    override fun alterar(id: UUID, livro: Livro): Livro {
        livroClient.alterar(Pair(id, livro))
        logger.info("enviando livro alterado com id: $id ao broken")
        return livro
    }

    override fun delete(id: UUID) {
        livroClient.delete(id)
        logger.info("enviando livro apagado com id: $id ao broken")

    }


}