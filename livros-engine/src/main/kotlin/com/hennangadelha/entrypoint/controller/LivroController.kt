package com.hennangadelha.entrypoint.controller

import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.port.LivroServicePort
import com.hennangadelha.entrypoint.dto.LivroResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/api/v1/livros")
class LivroController(val livroService: LivroServicePort) {


    @Get
    fun listarTodos() : HttpResponse<List<LivroResponse>> {

        val livros: List<LivroResponse> =
            livroService.findAll().map {
                LivroConverter.toLivroResponse(it)
            }

        return HttpResponse.ok(livros)

    }

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: UUID) : HttpResponse<LivroResponse> =
        HttpResponse.ok(LivroConverter.toLivroResponse(livroService.findById(id)))


}