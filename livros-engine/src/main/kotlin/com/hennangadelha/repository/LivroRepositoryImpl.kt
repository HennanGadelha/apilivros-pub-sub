package com.hennangadelha.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.hennangadelha.model.Livro
import jakarta.inject.Singleton
import java.util.*

@Singleton
class LivroRepositoryImpl(val cqlSession: CqlSession) : LivroRepository {


    override fun listarTodos(): List<Livro> {

        val resultQuery = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM livrosdb.livro")
        )

        return resultQuery.map {
            Livro(
                it.getUuid("id"),
                it.getString("titulo"),
                it.getString("editora")
            )
        }.toList()

    }

    override fun buscarPorId(id: UUID): Livro {

        val livro = cqlSession.execute(

            SimpleStatement.newInstance(
                "SELECT * FROM livrosdb.livro WHERE id = $id"
            )
        )

        return livro.map {
            Livro(
                it.getUuid("id"),
                it.getString("titulo"),
                it.getString("editora")
            )
        }.first()

    }
}