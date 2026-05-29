package com.unibo.android.data.di

import com.unibo.android.data.repositories.MovieRepositoryImpl
import com.unibo.android.domain.di.RepositoryProvider
import com.unibo.android.domain.repositories.MovieRepository // Assicurati di importare MovieRepository

class RepositoryProviderImpl : RepositoryProvider {
    // AGGIORNATO: Ora puntiamo alla MovieRepository
    override val movieRepository: MovieRepository = MovieRepositoryImpl()
}