package com.hennangadelha.infra


import com.hennangadelha.livro.model.Livro
import com.hennangadelha.livro.repository.LivroRepository
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsListener
class LivroNatsListener(val livroRepository: LivroRepository) {

    @Subject("livro")
    fun receive(@Body livro: Livro){
        livroRepository.cadastrar(livro)
        println(livro.toString())
    }

    @Subject("alterar-livro")
    fun alterar(id: String, livro: Livro){
        livroRepository.alterar(id, livro)
        println("alterado")
    }

    @Subject("deletar-livro")
    fun delete(id:String){
        livroRepository.deletar(id)
        println("deletado")
    }

}