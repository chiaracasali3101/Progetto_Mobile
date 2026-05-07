package com.unibo.android.corsolp2526.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // L'indirizzo base di TMDB valido per tutte le chiamate
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    // Creiamo materialmente l'istanza di Retrofit
    val tmdbApi: TmdbApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Spiega a Retrofit come leggere il JSON
            .build()
            .create(TmdbApi::class.java)
    }
}