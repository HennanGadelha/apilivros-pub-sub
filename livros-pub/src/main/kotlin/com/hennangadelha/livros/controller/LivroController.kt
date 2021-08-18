package com.hennangadelha.livros.controller

import com.hennangadelha.livros.models.Livro
import com.hennangadelha.infra.LivroNatsClient
import com.hennangadelha.infra.LivroNatsListener
import com.hennangadelha.livros.service.LivroService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/api/v1/livros")
class LivroController(val livroService: LivroService) {


    @Post
    fun cadastro(@Body request: Livro) {
        livroService.cadastrar(request)

    }


}