package com.hennangadelha.core.port

import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.infra.model.LivroEvent
import java.util.*

interface LivroEventServicePort {

    fun cadastrar(livroEntity: LivroEvent)

    fun alterar(livroEntity: Pair<UUID, LivroEvent>)

    fun deletar(id: UUID)

}