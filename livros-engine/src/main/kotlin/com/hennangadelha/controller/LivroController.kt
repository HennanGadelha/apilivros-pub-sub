package com.hennangadelha.controller

import com.hennangadelha.model.Livro
import com.hennangadelha.repository.LivroRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/api/v1/livros")
class LivroController(val livroRepository: LivroRepository) {


    @Get
    fun listarTodos() : HttpResponse<List<Livro>> = HttpResponse.ok(livroRepository.listarTodos())

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: UUID) : HttpResponse<Livro> = HttpResponse.ok(livroRepository.buscarPorId(id))


}