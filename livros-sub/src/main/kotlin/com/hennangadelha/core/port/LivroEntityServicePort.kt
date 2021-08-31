package com.hennangadelha.core.port

import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import java.util.*

interface LivroEntityServicePort {

    fun cadastrar(livroEntity: LivroEntity)

    fun alterar(id: UUID, livroEntity: LivroEntity)

    fun deletar(id: UUID)


}