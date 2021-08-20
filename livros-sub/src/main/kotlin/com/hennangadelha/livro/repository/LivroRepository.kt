package com.hennangadelha.livro.repository

import com.hennangadelha.livro.model.Livro
import java.util.*


interface LivroRepository {

    fun cadastrar(livro: Livro): Livro

    fun alterar(id: UUID, livro: Livro)

    fun deletar(id: UUID)


}