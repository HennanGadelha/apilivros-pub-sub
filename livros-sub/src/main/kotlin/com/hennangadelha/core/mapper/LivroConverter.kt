package com.hennangadelha.core.mapper

import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.infra.model.LivroEvent

class LivroConverter {

    companion object{

        fun toLivroEntity(livro: LivroEvent) = LivroEntity(livro.id, livro.titulo, livro.editora)

        fun toLivroEvent(livro: Livro)  = LivroEvent(livro.id, livro.titulo, livro.editora)





    }

}