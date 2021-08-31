package com.hennangadelha.entrypoint.controller

import com.hennangadelha.core.models.Livro
import com.hennangadelha.core.port.LivroServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/api/v1/livros")
class LivroController(val livroService: LivroServicePort) {


    @Post
    fun cadastro(@Body request: Livro) : HttpResponse<Any> =
        HttpResponse.ok(livroService.cadastrar(request))

    @Put("/{id}")
    fun alterar(@PathVariable id: UUID, @Body request: Livro) :
            HttpResponse<Any> = HttpResponse.ok(livroService.alterar(Pair(id,request)))

    @Delete("/{id}")
    fun deletar(@PathVariable id: UUID) : HttpResponse<Any> =
        HttpResponse.ok(livroService.delete(id))


}