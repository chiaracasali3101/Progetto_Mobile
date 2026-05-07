package com.unibo.android.corsolp2526.data.repository

import com.unibo.android.corsolp2526.data.api.TmdbApi
import com.unibo.android.corsolp2526.data.model.MovieDto
import com.unibo.android.corsolp2526.domain.repository.MovieRepository

// Questa classe prende l'API e la tua chiave come "strumenti" per lavorare
class MovieRepositoryImpl(
    private val api: TmdbApi,
    private val apiKey: String
) : MovieRepository {

    override suspend fun getPopularMovies(): List<MovieDto> {
        // 1. Facciamo la chiamata di rete passando la chiave
        val response = api.getPopularMovies(apiKey)

        // 2. Restituiamo solo la lista dei film (i "results") ignorando il resto
        return response.results
    }

    override suspend fun getTopRatedMovies(): List<MovieDto> {
        val response = api.getTopRatedMovies(apiKey)
        return response.results
    }
}