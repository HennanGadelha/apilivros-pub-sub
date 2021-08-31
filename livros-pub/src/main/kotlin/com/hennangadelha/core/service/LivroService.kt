package com.hennangadelha.core.service

import com.hennangadelha.core.mapper.LivroConverter
import com.hennangadelha.core.models.Livro
import com.hennangadelha.core.port.LivroEventServicePort
import com.hennangadelha.core.port.LivroServicePort
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroService(val livroNatsEvent: LivroEventServicePort): LivroServicePort {

    override fun cadastrar(livro: Livro) {
        livroNatsEvent.cadastrar(LivroConverter.toLivroEvent(livro))
    }

    override fun alterar(livro: Pair<UUID, Livro>) {
        livroNatsEvent.alterar(LivroConverter.toPairLivroEvent(Pair(livro.first, livro.second)))
    }

    override fun delete(id: UUID) {
        livroNatsEvent.delete(id)
    }
}