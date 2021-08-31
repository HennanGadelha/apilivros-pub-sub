package com.hennangadelha.infra.service

import com.hennangadelha.core.models.Livro

import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroNatsClientService {

    fun cadastrar(livro: Livro): Livro

    fun alterar(id: UUID, livro: Livro): Livro

    fun delete(id: UUID)


}