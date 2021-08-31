package com.hennangadelha.database

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.hennangadelha.core.model.Livro
import com.hennangadelha.core.port.LivroEntityServicePort
import com.hennangadelha.database.LivroRepository
import com.hennangadelha.database.model.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRepositoryImpl(val cqlSession: CqlSession) : LivroEntityServicePort {

    override fun cadastrar(livro: LivroEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO livro (id, titulo, editora) VALUES (?,?,?) IF NOT EXISTS",
                livro.id,
                livro.titulo,
                livro.editora
            )
        )

    }

    override fun alterar(id: UUID, livro: LivroEntity) {

        cqlSession.execute(
            SimpleStatement.newInstance(
                "UPDATE livrosdb.livro SET titulo = ?, editora = ? WHERE id = $id",
                livro.titulo,
                livro.editora,
            )
        )

    }

    override fun deletar(id: UUID) {
        cqlSession.execute(
            SimpleStatement
                .newInstance("DELETE FROM livrosdb.livro WHERE id = ?", id)
        )

    }



}