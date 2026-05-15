package com.unibo.android.domain.di

// Usiamo il nuovo nome MovieRepository al posto di AccommodationRepository
import com.unibo.android.domain.repositories.MovieRepository

interface RepositoryProvider {
    // Anche qui, cambiamo il nome della variabile per chiarezza
    val movieRepository: MovieRepository
}
