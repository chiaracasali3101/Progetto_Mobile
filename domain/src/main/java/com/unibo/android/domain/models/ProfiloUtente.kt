package com.unibo.android.domain.models

/**
 * Rappresenta i dati del profilo utente.
 * Inserito nel modulo domain per separare la logica dalla UI.
 */
data class UserProfile(
    val nome: String,
    val email: String,
    // Percorso dell'immagine
    val uriImmagine: String? = null,
    // Coordinate per la mappa dei cinema
    val latitudine: Double? = null,
    val longitudine: Double? = null
)