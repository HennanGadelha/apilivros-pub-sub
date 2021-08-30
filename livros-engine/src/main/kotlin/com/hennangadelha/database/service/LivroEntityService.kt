package com.hennangadelha.database.service

import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.port.LivroEntityServicePort
import com.hennangadelha.database.model.LivroEntity
import com.hennangadelha.database.repository.LivroRepository
import java.util.*

class LivroEntityService(val livroRepository: LivroRepository):LivroEntityServicePort {

    override fun findAll(): List<LivroEntity> {
        return livroRepository.listarTodos()
    }

    override fun findById(id: UUID): LivroEntity {
        TODO("Not yet implemented")
    }
}