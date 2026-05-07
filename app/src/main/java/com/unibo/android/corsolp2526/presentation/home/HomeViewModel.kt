package com.unibo.android.corsolp2526.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unibo.android.corsolp2526.data.model.MovieDto
import com.unibo.android.corsolp2526.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _popularMovies = MutableStateFlow<List<MovieDto>>(emptyList())
    val popularMovies: StateFlow<List<MovieDto>> = _popularMovies.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val movies = repository.getPopularMovies()
                _popularMovies.value = movies
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}