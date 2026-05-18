package com.unibo.android.data.repositories

import com.unibo.android.data.entities.FilmEntity
import com.unibo.android.data.local.FilmDao
import com.unibo.android.data.remote.FilmApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class FilmRepository(
    private val filmDao: FilmDao,
    private val apiService: FilmApiService
) {

    fun searchMovies(query: String, apiKey: String): Flow<List<FilmEntity>> = flow {
        val cache = filmDao.getFilmsByQuery("%$query%")
        emit(cache as List<FilmEntity>)

        try {

            val response = apiService.getFilmPopolari(apiKey = apiKey)

                val movieDtos = response.results

                val entities = movieDtos.map { dto ->
                    FilmEntity(
                        id = dto.id,
                        titolo = dto.titolo,
                        anno = dto.anno,
                        trama = dto.trama,
                        genere = dto.genere,
                        durata = dto.durata,
                        regista = dto.regista,
                        punteggio = 0.0,
                        percorsoLocandina = if (dto.percorsoLocandina != null) "https://image.tmdb.org/t/p/w500" + dto.percorsoLocandina else "",
                        preferito = false
                    )
                }

            entities.forEach { film ->
                filmDao.addWatchlist(movie = film)
            }
            emit(value = entities)

        } catch (e: Exception) {
        e.printStackTrace()
        }
    }

    suspend fun getFilmById(id: Int): FilmEntity? {
        return filmDao.getFilmById(id)
    }
}