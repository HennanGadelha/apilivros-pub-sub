package com.hennangadelha.infra

import com.hennangadelha.livros.models.Livro
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsClient
interface LivroNatsClient  {

    @Subject("livro")
    fun send(@Body livro: Livro)

    @Subject("alterar-livro")
    fun alterar(@Body livro: Pair<String, Livro>)

    @Subject("deletar-livro")
    fun delete(id: String)

}