package com.unibo.android.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unibo.android.data.local.entities.FilmEntity
import com.unibo.android.data.repositories.FilmRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FilmViewModel(private val repository: FilmRepository) : ViewModel() {

    var searchQuery by mutableStateOf("")
        private set

    private val _risultatiRicerca = MutableStateFlow<List<FilmEntity>>(emptyList())
    val risultatiRicerca: StateFlow<List<FilmEntity>> = _risultatiRicerca.asStateFlow()

    fun onSearchChanged(newQuery: String) {
        searchQuery = newQuery
        cercaFilm(newQuery)
    }

    private fun cercaFilm(query: String) {

        if (query.isBlank()) {
            _risultatiRicerca.value = emptyList()
            return
        }

        viewModelScope.launch {
            try {
                // Chiediamo al repository di cercarci i film (dal web o DB)
                repository.searchMovies(query).collect { listaFilm ->
                    _risultatiRicerca.value = listaFilm
                }
            } catch (e: Exception) {

                _risultatiRicerca.value = emptyList()
            }
        }
    }
}