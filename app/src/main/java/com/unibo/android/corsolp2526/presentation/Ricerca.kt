package com.unibo.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unibo.android.ui.components.FilmCard
import com.unibo.android.data.entities.FilmEntity
import androidx.compose.foundation.lazy.items


@Composable
fun Ricerca(
    query: String,
    listaFilm: List<FilmEntity>,
    onQueryChange: (String) -> Unit,
    onMovieClick: (FilmEntity) -> Unit
) {
    Scaffold(
        topBar = {
            OutlinedTextField(
                value = query,
                onValueChange = { nuovoTesto -> onQueryChange(nuovoTesto) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                label = { Text("Cerca un film...") },
                singleLine = true
            )
        }
    ) { paddingValues ->

        // Se la lista è vuota mostriamo un messaggio, altrimenti mostriamo i film
        if (listaFilm.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(text = "Nessun film trovato", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(listaFilm) { film ->
                    FilmCard(
                        film = film,
                        onClick = {
                            onMovieClick(film)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RicercaPreview() {
    val filmFinti = listOf(
        FilmEntity(
            id = 1,
            titolo = "Batman",
            anno = "2022",
            trama = "Trama di Batman...",
            genere = "Azione",
            durata = "175 min",
            regista = "Matt Reeves",
            punteggio = 7.8,
            percorsoLocandina = "",
            preferito = false
        ),
        FilmEntity(
            id = 2,
            titolo = "Interstellar",
            anno = "2014",
            trama = "Trama di Interstellar...",
            genere = "Sci-Fi",
            durata = "169 min",
            regista = "C. Nolan",
            punteggio = 8.6,
            percorsoLocandina = "",
            preferito = true
        )
    )

    Ricerca(
        query = "Batman",
        listaFilm = filmFinti,
        onQueryChange = { },
        onMovieClick = { }
    )
}