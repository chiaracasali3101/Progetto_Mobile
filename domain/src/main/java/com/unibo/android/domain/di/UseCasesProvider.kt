package com.unibo.android.domain.di

import com.unibo.android.domain.usecases.GetMovieListUseCase
import com.unibo.android.domain.usecases.GetMovieListUseCaseImpl
import com.unibo.android.domain.usecases.StartFetchMovieListUseCase
import com.unibo.android.domain.usecases.StartFetchMovieListUseCaseImpl

object UseCasesProvider {

    lateinit var startFetchMovieListUseCase: StartFetchMovieListUseCase
    lateinit var getMovieListUseCase: GetMovieListUseCase // Aggiornato qui

    fun setup(
        repositoryProvider: RepositoryProvider
    ) {
        startFetchMovieListUseCase = StartFetchMovieListUseCaseImpl(
            movieRepository = repositoryProvider.movieRepository
        )

        // Aggiornato qui con il nuovo caso d'uso esistente
        getMovieListUseCase = GetMovieListUseCaseImpl(
            movieRepository = repositoryProvider.movieRepository
        )
    }
}
