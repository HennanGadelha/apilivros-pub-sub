package com.hennangadelha.infra


import com.hennangadelha.livro.model.Livro
import com.hennangadelha.livro.repository.LivroRepository
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class LivroNatsListener(val livroRepository: LivroRepository) {

    @Subject("livro")
    fun receive(@Body livro: Livro){
        livroRepository.cadastrar(livro)
        println(livro.toString())
    }


}