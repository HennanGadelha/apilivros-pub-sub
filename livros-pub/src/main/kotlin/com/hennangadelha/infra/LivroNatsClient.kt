package com.hennangadelha.infra

import com.hennangadelha.livros.models.Livro
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface LivroNatsClient  {

    @Subject("livro")
    fun send(@Body livro: Livro)

    @Subject("teste")
    fun teste(teste: String){
        println(teste)
    }

}