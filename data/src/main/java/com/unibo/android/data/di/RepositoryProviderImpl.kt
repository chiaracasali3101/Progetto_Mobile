package com.unibo.android.data.di

import com.unibo.android.data.repositories.MovieRepositoryImpl
import com.unibo.android.domain.di.RepositoryProvider
import com.unibo.android.domain.repositories.AccommodationRepository

class RepositoryProviderImpl: RepositoryProvider {
    override val accommodationRepository: AccommodationRepository = MovieRepositoryImpl()
}