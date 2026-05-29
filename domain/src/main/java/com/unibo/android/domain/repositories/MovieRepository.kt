package com.unibo.android.domain.repositories

import com.unibo.android.domain.models.FilmType
import kotlinx.coroutines.flow.StateFlow

interface MovieRepository {
    val movieList: StateFlow<List<FilmType>>
    fun startFetchMovieList()
}