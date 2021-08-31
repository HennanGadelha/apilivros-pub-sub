package com.hennangadelha.core.mapper

import com.hennangadelha.core.models.Livro
import com.hennangadelha.entrypoint.dto.LivroResponse
import com.hennangadelha.infra.models.LivroEvent
import java.util.*

class LivroConverter {

    companion object{

        fun toLivroResponse(livro: Livro) = LivroResponse(livro.id, livro.titulo, livro.editora)

        fun toLivroEvent(livro: Livro) = LivroEvent(livro.id, livro.titulo, livro.editora)

        fun toPairLivroEvent(livro: Pair<UUID, Livro>) = Pair(livro.first, toLivroEvent(livro.second))



    }
}