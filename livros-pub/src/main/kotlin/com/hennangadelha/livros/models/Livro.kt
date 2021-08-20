package com.hennangadelha.livros.models

import java.util.*

data class Livro(val titulo: String, val editora: String) {

    val id: UUID? = UUID.randomUUID()

}
