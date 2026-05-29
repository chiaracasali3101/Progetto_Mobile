package com.unibo.android.corsolp2526.domain.repository

import com.unibo.android.corsolp2526.data.model.MovieDto

interface MovieRepository {
    suspend fun getPopularMovies(): List<MovieDto>

    suspend fun getTopRatedMovies(): List<MovieDto>
}