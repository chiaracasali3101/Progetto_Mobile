package com.unibo.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    // Colori dell'applicazione salvati in variabili locali
    val sfondoMarrone = Color(0xFF210100)
    val coloreCrema = Color(0xFFFECE79)
    val coloreOro = Color(0xFFE6A341)
    val coloreRossoTesto = Color(0xFFB14A36)
    val coloreRossoBottoni = Color(0xFF8C0902)

    // Stato per gestire l'apertura del menu per la foto
    var mostraMenuFoto by remember { mutableStateOf(false) }

    // Liste di dati per riempire la pagina
    val listaFilmVisti = listOf(
        Pair("Inception", "8.5"),
        Pair("Interstellar", "8.5"),
        Pair("Pulp Fiction", "9.0"),
        Pair("WinterMarter", "8.5"),
        Pair("Sal:lisare", "8.5"),
        Pair("The Prestige", "8.8")
    )

    val listaWatchlist = listOf(
        "Dune: Part Two",
        "Oppenheimer",
        "The Batman",
        "Blade Runner 2049",
        "Gladiator 2"
    )

    // Contenitore principale con lo scroll attivo per scendere nella pagina
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(sfondoMarrone)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "re", color = coloreCrema, fontSize = 22.sp)
                Text(text = "View", color = Color.Red, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "IL TUO PROFILO", color = coloreCrema, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))


            Box(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF350B0A))
                    .border(3.dp, coloreOro, CircleShape)
                    .clickable { mostraMenuFoto = true },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Avatar",
                    modifier = Modifier.size(80.dp),
                    tint = coloreCrema.copy(alpha = 0.6f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Cambia Foto Profilo",
                color = coloreOro,
                fontSize = 12.sp,
                modifier = Modifier.clickable { mostraMenuFoto = true }
            )

            Spacer(modifier = Modifier.height(15.dp))

            // --- DATI ANAGRAFICI ---
            Text(text = "Ana", color = coloreCrema, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(text = "ana.systemexpert@unibo.it", color = coloreCrema.copy(alpha = 0.6f), fontSize = 14.sp)

            Spacer(modifier = Modifier.height(25.dp))


            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                // Box Film Visti
                Card(
                    modifier = Modifier.weight(1f).height(60.dp),
                    colors = CardDefaults.cardColors(containerColor = coloreRossoBottoni.copy(alpha = 0.6f)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "52", color = coloreCrema, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Film Visti", color = coloreCrema, fontSize = 12.sp)
                    }
                }

                // Box Recensioni
                Card(
                    modifier = Modifier.weight(1f).height(60.dp),
                    colors = CardDefaults.cardColors(containerColor = coloreRossoBottoni.copy(alpha = 0.6f)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "14", color = coloreCrema, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Recensioni", color = coloreCrema, fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))


            Button(
                onClick = { /* Bottone che aprirà la mappa */ },
                modifier = Modifier.fillMaxWidth(0.8f).height(45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = coloreRossoBottoni),
                shape = RoundedCornerShape(6.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "CERCA SALE VICINE", color = coloreCrema, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Mappa", tint = coloreCrema)
                }
            }

            Spacer(modifier = Modifier.height(35.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // COLONNA 1: FILM VISTI
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "FILM VISTI RECENTEMENTE",
                        color = coloreCrema,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Ciclo standard per stampare i film visti
                    for (film in listaFilmVisti) {
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF3A0605).copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Star, contentDescription = "Stella", tint = Color.Red, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(text = film.first, color = coloreCrema, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                        Text(text = "26/02/2026", color = Color.Gray, fontSize = 10.sp)
                                    }
                                }
                                Text(text = film.second, color = coloreRossoTesto, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                // COLONNA 2: WATCHLIST
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "WATCHLIST",
                        color = coloreCrema,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Ciclo standard per stampare la watchlist
                    for (film in listaWatchlist) {
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF3A0605).copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Bookmark, contentDescription = "Segnalibro", tint = coloreOro, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = film, color = coloreCrema, fontSize = 14.sp)
                                }
                                Text(text = "Da vedere", color = coloreRossoTesto, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }


        if (mostraMenuFoto) {
            ModalBottomSheet(
                onDismissRequest = { mostraMenuFoto = false },
                containerColor = Color(0xFF2A0302),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(20.dp).navigationBarsPadding()) {
                    Text(text = "Immagine del profilo", color = coloreCrema, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(15.dp))

                    Row(modifier = Modifier.fillMaxWidth().clickable { mostraMenuFoto = false }.padding(vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.AddAPhoto, contentDescription = "Scatta", tint = coloreOro)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Scatta una foto direttamente", color = coloreCrema)
                    }

                    HorizontalDivider(color = sfondoMarrone, thickness = 1.dp)

                    Row(modifier = Modifier.fillMaxWidth().clickable { mostraMenuFoto = false }.padding(vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.PhotoLibrary, contentDescription = "Galleria", tint = coloreOro)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Seleziona dalla galleria", color = coloreCrema)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 900)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}