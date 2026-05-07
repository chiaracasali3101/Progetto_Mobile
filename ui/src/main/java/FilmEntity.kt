package com.unibo.android.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tabella = "watchlist")

data class FilmEntity(
    @PrimaryKey val titolo: String,
    val anno: String,
    val trama: String,
    val genere: String,
    val durata: String,
    val regista: String,
    val punteggio: Double,
    val preferito: Boolean = false
)