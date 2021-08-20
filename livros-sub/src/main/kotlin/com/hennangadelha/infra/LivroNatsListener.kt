package com.hennangadelha.infra


import com.hennangadelha.livro.model.Livro
import com.hennangadelha.livro.repository.LivroRepository
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@NatsListener
class LivroNatsListener(val livroRepository: LivroRepository) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Subject("livro")
    fun receive(@Body livro: Livro) {
        livroRepository.cadastrar(livro)
        logger.info("recebendo livro: ${livro.toString()} do broken")
    }

    @Subject("alterar.livro")
    fun alterar(livro: Pair<UUID, Livro>) {

        livroRepository.alterar(livro.first, livro.second)
        logger.info("recebendo livro alterado com id: ${livro.first} do broken")

    }

    @Subject("deletar.livro")
    fun delete(@Body id: UUID) {
        livroRepository.deletar(id)
        logger.info("recebendo livro apagado com id: $id do broken")
    }

}