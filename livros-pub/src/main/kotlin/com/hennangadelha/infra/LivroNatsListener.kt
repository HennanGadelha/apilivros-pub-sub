package com.hennangadelha.infra



import com.hennangadelha.livros.models.Livro

import io.micronaut.messaging.annotation.MessageBody
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject



@NatsListener
interface LivroNatsListener {

    @Subject("livro")
    fun receive(@MessageBody livro: Livro){
        println("recebendo mensagem $livro")
    }

    @Subject("teste")
    fun teste(teste: String){
        println(teste)
    }

}