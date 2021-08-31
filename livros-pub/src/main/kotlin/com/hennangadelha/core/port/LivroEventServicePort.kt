package com.hennangadelha.core.port

import com.hennangadelha.core.models.Livro
import com.hennangadelha.infra.models.LivroEvent
import java.util.*

interface LivroEventServicePort {

    fun cadastrar(livroEvent: LivroEvent)

    fun alterar(livroEvent: Pair<UUID, LivroEvent>)

    fun delete(id: UUID)

}