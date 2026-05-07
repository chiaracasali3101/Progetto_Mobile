package com.unibo.android.data.remote

import com.google.gson.annotations.SerializedName
data class TmdbResponse(
    val results: List<TmdbMovieDto>
)

data class TmdbMovieDto(
    val id: Int,
    val titolo: String,
    val anno: String,
    val trama: String,
    val genere: String,
    val durata: String,
    val regista: String,
)