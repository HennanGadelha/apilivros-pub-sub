package com.hennangadelha.core.service

import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.model.Livro
import com.hennangadelha.core.port.LivroServicePort
import com.hennangadelha.database.service.LivroEntityService
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroService(val livroEntityService: LivroEntityService): LivroServicePort {

    override fun findAll(): List<Livro> {
       return LivroConverter.toLivroList(livroEntityService.findAll())
    }

    override fun findById(id: UUID): Livro {
        return LivroConverter.toLivro(livroEntityService.findById(id))
    }


}