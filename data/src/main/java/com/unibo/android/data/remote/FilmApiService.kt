package com.unibo.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApiService {
    @GET("movie/popular")
    suspend fun getFilmPopolari(
        @Query("api_key") apiKey: String,
        @Query("language") lingua: String = "it-IT"
    ): TmdbResponse
}