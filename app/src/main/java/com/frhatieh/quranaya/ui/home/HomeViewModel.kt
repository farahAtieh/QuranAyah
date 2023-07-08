package com.frhatieh.quranaya.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.quranaya.data.usecases.GetRandomVerseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomVerseUseCase: GetRandomVerseUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<LoadedState> =
        MutableStateFlow(LoadedState.Loading)
    val state: StateFlow<LoadedState> =
        _state

    private val _isRefreshing: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> =
        _isRefreshing

    init {
        getRandomVerse()
    }

    private fun getRandomVerse(isForceRefresh: Boolean = false) {
        if (isForceRefresh) {
            _isRefreshing.value = true
        } else {
            _state.value = LoadedState.Loading
        }

        viewModelScope.launch {
            _state.value = try {
                val data = getRandomVerseUseCase.invoke(UTHMANI_TEXT)
                LoadedState.Loaded(data)
            } catch (e: Exception) {
                LoadedState.Error
            }
            _isRefreshing.value = false
        }
    }

    fun onRefresh() {
        getRandomVerse(true)
    }

    companion object {
        val UTHMANI_TEXT = "text_uthmani"
    }
}