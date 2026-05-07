package com.unibo.android.corsolp2526.presentation.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unibo.android.corsolp2526.data.model.MovieDto
import com.unibo.android.corsolp2526.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClassificaViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _topRatedMovies = MutableStateFlow<List<MovieDto>>(emptyList())
    val topRatedMovies: StateFlow<List<MovieDto>> = _topRatedMovies.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val movies = repository.getTopRatedMovies()
                _topRatedMovies.value = movies
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}