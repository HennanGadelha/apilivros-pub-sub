package com.hennangadelha.infra


import com.hennangadelha.livro.model.Livro
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
interface LivroNatsListener {

    @Subject("livro")
    fun receive(@Body livro: Livro){
        println(livro)
    }


}