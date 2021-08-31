package com.hennangadelha.infra.service

import com.hennangadelha.core.models.Livro
import com.hennangadelha.core.port.LivroEventServicePort
import com.hennangadelha.infra.client.LivroNatsClient
import com.hennangadelha.infra.models.LivroEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroNatsClientServicempl(private val livroClient: LivroNatsClient) : LivroEventServicePort {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    override fun cadastrar(livroEvent: LivroEvent) {
        livroClient.send(livroEvent)
        logger.info("Enviando livro ao broken: ${livroEvent.toString()}")
    }

    override fun alterar(livroEvent: Pair<UUID, LivroEvent>) {
        livroClient.alterar(Pair(livroEvent.first, livroEvent.second))
        logger.info("enviando livro alterado com id: ${livroEvent.first} ao broken")
    }

    override fun delete(id: UUID) {
        livroClient.delete(id)
        logger.info("enviando livro apagado com id: $id ao broken")
    }


}