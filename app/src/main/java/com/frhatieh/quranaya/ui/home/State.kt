package com.frhatieh.quranaya.ui.home

import com.frhatieh.quranaya.data.model.Verse

sealed class LoadedState {
    object Loading : LoadedState()
    class Loaded(val data: Verse) : LoadedState()
    object Error : LoadedState()
}