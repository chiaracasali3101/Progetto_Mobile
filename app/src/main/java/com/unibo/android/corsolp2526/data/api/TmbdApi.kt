package com.unibo.android.corsolp2526.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.unibo.android.corsolp2526.data.model.MovieResponse
interface TmdbApi {

    // Chiamata per i film popolari (Per la tua Home)
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "it-IT"
    ): MovieResponse

    // Chiamata per i film con voti più alti (Per la tua Classifica)
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "it-IT"
    ): MovieResponse
}