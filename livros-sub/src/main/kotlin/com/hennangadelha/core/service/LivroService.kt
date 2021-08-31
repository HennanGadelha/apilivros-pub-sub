package com.hennangadelha.core.service

import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.port.LivroEntityServicePort
import com.hennangadelha.core.port.LivroEventServicePort
import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.infra.model.LivroEvent
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroService(val livroEntityServicePort: LivroEntityServicePort): LivroEventServicePort {


    override fun cadastrar(livroEntity: LivroEvent) {
        livroEntityServicePort.cadastrar(LivroConverter.toLivroEntity(livroEntity))
    }

    override fun alterar(livroEntity: Pair<UUID, LivroEvent>) {
        livroEntityServicePort.alterar(livroEntity.first, LivroConverter.toLivroEntity(livroEntity.second))
    }

    override fun deletar(id: UUID) {
        livroEntityServicePort.deletar(id)
    }


}