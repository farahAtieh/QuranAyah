package com.frhatieh.quranaya.ui.savedverses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.usecases.DeleteVerseFromSavedUseCase
import com.frhatieh.quranaya.data.usecases.GetSavedVersesUseCase
import com.frhatieh.quranaya.shared.util.LoadedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedVersesViewModel @Inject constructor(
    private val getSavedVersesUseCase: GetSavedVersesUseCase,
    private val deleteVerseFromFavoriteUseCase: DeleteVerseFromSavedUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LoadedState.Loading)
    val state: StateFlow<LoadedState> = _state

    var verses: Flow<List<Verse>> = flow { emit(emptyList()) }

    init {
        getSavedVerses()
    }

    private fun getSavedVerses() {
        _state.value = LoadedState.Loading

        viewModelScope.launch {
            _state.value = try {
                verses = getSavedVersesUseCase.invoke()
                LoadedState.Loaded
            } catch (e: Exception) {
                LoadedState.Error
            }
        }
    }

    fun unSaveVerse(verse: Verse) {
        viewModelScope.launch {
            deleteVerseFromFavoriteUseCase.invoke(verse)
        }
    }
}