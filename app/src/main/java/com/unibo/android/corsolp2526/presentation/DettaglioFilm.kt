package com.unibo.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.unibo.android.data.entities.FilmEntity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import com.unibo.android.ui.components.FilmCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DettaglioFilm(film: FilmEntity, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("Dettaglio Film") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${film.percorsoLocandina}",
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(300.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = film.titolo, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Trama", style = MaterialTheme.typography.titleLarge)
                Text(text = film.trama, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(24.dp))

                Button(onClick = { /* Azione per salvare */ }, modifier = Modifier.fillMaxWidth()) {
                    Text("Aggiungi alla Watchlist")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DettaglioFilmPreview() {
    DettaglioFilm(
        film = FilmEntity(
            id = 1,
            titolo = "Inception",
            anno = "2010",
            trama = "Un ladro professionista che si infiltra nei segreti delle persone attraverso il mondo dei sogni deve compiere l'operazione inversa: innestare un'idea.",
            genere = "Fantascienza",
            durata = "148 min",
            regista = "Christopher Nolan",
            punteggio = 8.8,
            percorsoLocandina = "",
            preferito = false
        ),
        onBack = {  }
    )
}