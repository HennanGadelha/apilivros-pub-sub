package com.hennangadelha.infra.client

import com.hennangadelha.core.models.Livro
import com.hennangadelha.infra.models.LivroEvent
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsClient
interface LivroNatsClient {

    @Subject("livro")
    fun send(@Body livro: LivroEvent)

    @Subject("alterar.livro")
    fun alterar(@Body livro: Pair<UUID, LivroEvent>)

    @Subject("deletar.livro")
    fun delete(@Body id: UUID)


}