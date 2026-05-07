package com.unibo.android.data.repository

import com.unibo.android.data.local.FilmDao
import com.unibo.android.data.local.FilmEntity
import com.unibo.android.data.remote.FilmApiService

class FilmRepository(
    private val filmDao: FilmDao,
    private val apiService: FilmApiService
) {
    private val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

    // Legge i film salvati nel DB locale
    val tuttiIFilm = filmDao.getTuttiIFilm()

    suspend fun sincronizzaFilm(apiKey: String) {
        try {
            // chiamata a TMDB
            val risposta = apiService.getFilmPopolari(apiKey)

            val entities = risposta.results.map { dto ->
                FilmEntity(
                    id = dto.id,
                    titolo = dto.title,
                    trama = dto.overview,

                    percorsoLocandina = if (dto.posterPath != null) BASE_IMAGE_URL + dto.posterPath else ""
                )
            }

            // salvataggio nel DB locale
            entities.forEach { filmDao.inserisciFilm(it) }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}