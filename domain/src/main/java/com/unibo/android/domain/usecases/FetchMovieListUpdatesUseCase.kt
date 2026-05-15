package com.unibo.android.domain.usecases

import com.unibo.android.domain.models.FilmType
import com.unibo.android.domain.repositories.MovieRepository

// Interfaccia per il caso d'uso del recupero film
interface GetMovieListUseCase {
    suspend fun execute(): List<FilmType>
}


class GetMovieListUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetMovieListUseCase {

    override suspend fun execute(): List<FilmType> {
        return movieRepository.getMovies()
    }
}