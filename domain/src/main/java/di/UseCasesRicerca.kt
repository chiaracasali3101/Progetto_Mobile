package com.unibo.android.domain.di

import com.unibo.android.data.entities.FilmEntity
import com.unibo.android.data.repository.FilmRepository

class UseCasesRicerca(
    private val repository: FilmRepository
) {

    suspend operator fun invoke(query: String): List<FilmEntity> {
        return repository.getFilmsByQuery(query)
    }

}