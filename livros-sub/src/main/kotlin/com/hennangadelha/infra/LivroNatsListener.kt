package com.hennangadelha.infra


import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.model.Livro
import com.hennangadelha.core.port.LivroEntityServicePort
import com.hennangadelha.database.LivroRepository
import com.hennangadelha.infra.model.LivroEvent
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@NatsListener
class LivroNatsListener(val livroRepository: LivroEntityServicePort) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Subject("livro")
    fun receive(@Body livro: LivroEvent) {
        livroRepository.cadastrar(LivroConverter.toLivroEntity(livro))
        logger.info("recebendo livro: ${livro.toString()} do broken")
    }

    @Subject("alterar.livro")
    fun alterar(livro: Pair<UUID, LivroEvent>) {

        livroRepository.alterar(livro.first, LivroConverter.toLivroEntity(livro.second))
        logger.info("recebendo livro alterado com id: ${livro.first} do broken")

    }

    @Subject("deletar.livro")
    fun delete(@Body id: UUID) {
        livroRepository.deletar(id)
        logger.info("recebendo livro apagado com id: $id do broken")
    }

}