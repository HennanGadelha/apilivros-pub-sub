package com.hennangadelha.core.port

import com.hennangadelha.core.models.Livro
import java.util.*

interface LivroServicePort {


    fun cadastrar(livro: Livro)

    fun alterar(livro: Pair<UUID, Livro>)

    fun delete(id: UUID)


}