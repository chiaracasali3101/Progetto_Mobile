package com.unibo.android.data.repositories

import com.unibo.android.data.local.dao.FilmDao
import com.unibo.android.data.local.entities.FilmEntity
import com.unibo.android.data.remote.api.FilmApiService
import com.unibo.android.data.remote.dto.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class FilmRepository(
    private val filmDao: FilmDAO,
    private val apiService: FilmApiService
) {

    fun searchMovies(query: String): Flow<List<FilmEntity>> = flow {
        val cache = filmDao.getFilmsByQuery("%$query%")
        emit(cache)

        try {

            val response = apiService.searchMovies(query = query)

            if (response.isSuccessful) {
                val movieDtos = response.body()?.results ?: emptyList()


                val entities = movieDtos.map { it.toEntity() }

                filmDao.insertAll(entities)

                emit(entities)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getFilmById(id: Int): Flow<FilmEntity?> {
        return filmDao.getFilmById(id)
    }
}