package com.hennangadelha.core.port

import com.hennangadelha.database.model.LivroEntity
import java.util.*

interface LivroRepositoryPort {


    fun findAll(): List<LivroEntity>

    fun findById(id: UUID): LivroEntity

}