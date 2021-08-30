package com.hennangadelha.core.mapper

import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.entrypoint.dto.LivroResponse

class LivroConverter {

    companion object {

        fun toLivroEntity(livro: Livro): LivroEntity =
            LivroEntity(livro.id, livro.titulo, livro.editora)


        fun toLivroResponse(livro: Livro): LivroResponse =
            LivroResponse(livro.id, livro.titulo, livro.editora)


        fun toLivro(livroEntity: LivroEntity) =
            Livro(livroEntity.id, livroEntity.titulo, livroEntity.editora)

        fun toLivroList(livroEntityList: List<LivroEntity>) =
            livroEntityList.map { toLivro(it) }

    }


}