package com.unibo.android.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unibo.android.domain.models.FilmType // Usiamo FilmType
import com.unibo.android.domain.usecases.GetMovieListUseCase // Il nuovo UseCase
import com.unibo.android.domain.usecases.StartFetchMovieListUseCase // Il nuovo StartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val startFetchAccommodationListUseCase: StartFetchMovieListUseCase,
    private val fetchAccommodationListUpdatesUseCase: GetMovieListUseCase
): ViewModel() {

    // Cambiato in FilmType
    private val _accommodationTypeList = MutableStateFlow<List<FilmType>>(emptyList())
    val accommodationTypeList: StateFlow<List<FilmType>> = _accommodationTypeList

    init {
        // Se vuoi caricare i dati all'avvio, puoi chiamare una funzione qui
    }

    fun startFetchAccommodationList() {
        // Nota: se nel tuo UseCase il metodo si chiama execute(), usa .execute()
        startFetchAccommodationListUseCase.invoke()
    }

    // Se questo metodo ti dà errore perché GetMovieListUseCase non è un Flow,
    // puoi commentarlo o adattarlo. Per ora lo sistemiamo per non bloccare il Build:
    private fun fetchAccommodationListUpdates() {
        viewModelScope.launch {
            val list = fetchAccommodationListUpdatesUseCase.execute()
            _accommodationTypeList.value = list
        }
    }
}