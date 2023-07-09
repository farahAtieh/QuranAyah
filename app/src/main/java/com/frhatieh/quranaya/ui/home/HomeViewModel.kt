package com.frhatieh.quranaya.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.usecases.DeleteVerseFromSavedUseCase
import com.frhatieh.quranaya.data.usecases.GetRandomVerseUseCase
import com.frhatieh.quranaya.data.usecases.InsertVerseToSavedUseCase
import com.frhatieh.quranaya.util.LoadedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomVerseUseCase: GetRandomVerseUseCase,
    private val insertVerseToSavedUseCase: InsertVerseToSavedUseCase,
    private val deleteVerseFromFavoriteUseCase: DeleteVerseFromSavedUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<LoadedState> =
        MutableStateFlow(LoadedState.Loading)
    val state: StateFlow<LoadedState> = _state

    private var _verse = MutableStateFlow<Verse?>(null)
    val verse: StateFlow<Verse?> = _verse

    private val _isRefreshing: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

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
                _verse.value =
                    getRandomVerseUseCase.invoke(UTHMANI_TEXT)
                LoadedState.Loaded
            } catch (e: Exception) {
                LoadedState.Error
            }
            _isRefreshing.value = false
        }
    }

    fun onRefresh() {
        getRandomVerse(true)
    }

    fun handleSaveClick(verse: Verse) {
        if (verse.isSaved) {
            delete(verse)
            _verse.value = verse.copy(isSaved = false)
        } else {
            insert(verse)
            _verse.value = verse.copy(isSaved = true)
        }
    }

    private fun insert(verse: Verse) {
        viewModelScope.launch {
            insertVerseToSavedUseCase.invoke(verse)
        }
    }

    private fun delete(verse: Verse) {
        viewModelScope.launch {
            deleteVerseFromFavoriteUseCase.invoke(verse)
        }
    }

    companion object {
        const val UTHMANI_TEXT = "text_uthmani"
    }
}