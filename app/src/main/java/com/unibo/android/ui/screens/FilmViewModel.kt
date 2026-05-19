package com.unibo.android.corsolp2526

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unibo.android.data.entities.FilmEntity
import com.unibo.android.domain.di.UseCasesProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel() {

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
                UseCasesProvider.useCasesRicerca.execute(query).toString()
            } catch (e: Exception) {
                _risultatiRicerca.value = emptyList()
            }
        }
    }
}