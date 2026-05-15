package com.unibo.android.domain.di

import com.unibo.android.domain.usecases.FetchMovieListUpdatesUseCase
import com.unibo.android.domain.usecases.FetchMovieListUpdatesUseCaseImpl
import com.unibo.android.domain.usecases.StartFetchMovieListUseCase
import com.unibo.android.domain.usecases.StartFetchMovieListUseCaseImpl

object UseCasesProvider {

    lateinit var startFetchMovieListUseCase: StartFetchMovieListUseCase
    lateinit var fetchMovieListUpdatesUseCase: FetchMovieListUpdatesUseCase

    fun setup(
        repositoryProvider: RepositoryProvider
    ) {
        startFetchMovieListUseCase = StartFetchMovieListUseCaseImpl(
            movieRepository = repositoryProvider.movieRepository
        )

        fetchMovieListUpdatesUseCase = FetchMovieListUpdatesUseCaseImpl(
            movieRepository = repositoryProvider.movieRepository
        )
    }
}
