package com.frhatieh.quranaya.data.usecases

import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.repository.VerseRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class InsertVerseToSavedUseCase @Inject constructor(
    private val repository: VerseRepository
) {

    suspend fun invoke(verse: Verse) = repository.insert(verse.copy(isSaved = true))
}