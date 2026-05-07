package com.unibo.android.corsolp2526.data.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String, // La trama
    @SerializedName("poster_path") val posterPath: String?, // La locandina
    @SerializedName("vote_average") val voteAverage: Double, // Per la tua classifica!
    @SerializedName("release_date") val releaseDate: String?
)