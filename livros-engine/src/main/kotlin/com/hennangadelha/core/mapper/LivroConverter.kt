package com.hennangadelha.core.mapper

import com.datastax.oss.driver.internal.mapper.processor.util.generation.PropertyType
import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.entrypoint.controller.dto.LivroResponse
import java.util.*

class LivroConverter {

    companion object{
        fun toLivroEntity(livro: Livro) : LivroEntity{

            return LivroEntity(livro.id, livro.titulo,livro.editora)
        }

        fun toLivroResponse(livro: Livro) : LivroResponse{
            return LivroResponse(livro.id, livro.titulo,livro.editora)
        }

        fun toLivro(livroEntity: LivroEntity) = Livro(livroEntity.id, livroEntity.titulo, livroEntity.editora)

        fun toLivroList(livroEntityList: List<LivroEntity>) = livroEntityList.map { toLivro(it) }

    }


}