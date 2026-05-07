package com.unibo.android.corsolp2526.presentation.detail

import androidx.lifecycle.ViewModel
import com.unibo.android.corsolp2526.data.model.MovieDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DettaglioViewModel : ViewModel() {

    private val _selectedMovie = MutableStateFlow<MovieDto?>(null)
    val selectedMovie: StateFlow<MovieDto?> = _selectedMovie.asStateFlow()

    fun selectMovie(movie: MovieDto) {
        _selectedMovie.value = movie
    }
}