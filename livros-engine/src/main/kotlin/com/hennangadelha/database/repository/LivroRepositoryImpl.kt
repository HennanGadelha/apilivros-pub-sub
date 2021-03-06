package com.hennangadelha.database.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.hennangadelha.core.model.Livro
import com.hennangadelha.database.model.LivroEntity


import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRepositoryImpl(val cqlSession: CqlSession) : LivroRepository {


    override fun listarTodos(): List<LivroEntity> {

        val resultQuery = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM livrosdb.livro")
        )

        return resultQuery.map {
            LivroEntity(
                it.getUuid("id"),
                it.getString("titulo"),
                it.getString("editora")
            )
        }.toList()

    }

    override fun buscarPorId(id: UUID): LivroEntity {

        val livro = cqlSession.execute(

            SimpleStatement.newInstance(
                "SELECT * FROM livrosdb.livro WHERE id = $id"
            )
        )

        return livro.map {
            LivroEntity(
                it.getUuid("id"),
                it.getString("titulo"),
                it.getString("editora")
            )
        }.first()

    }
}