package com.hennangadelha.core.port

import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity
import java.util.*

interface LivroServicePort {


    fun findAll(): List<Livro>

    fun findById(id: UUID): Livro
}