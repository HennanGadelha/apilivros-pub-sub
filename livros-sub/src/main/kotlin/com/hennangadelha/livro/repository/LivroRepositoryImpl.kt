package com.hennangadelha.livro.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.hennangadelha.infra.LivroNatsListener
import com.hennangadelha.livro.model.Livro
import javax.inject.Singleton

@Singleton
class LivroRepositoryImpl(val cqlSession: CqlSession) : LivroRepository {

    override fun cadastrar(livro: Livro): Livro {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO livro (id, titulo, editora) VALUES (?, ?,?) IF NOT EXISTS",
                livro.id,
                livro.titulo,
                livro.editora
            )
        )
        return livro
    }
}