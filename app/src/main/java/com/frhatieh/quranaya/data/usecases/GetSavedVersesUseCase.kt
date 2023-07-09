package com.frhatieh.quranaya.data.usecases

import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.repository.VerseRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetSavedVersesUseCase @Inject constructor(
    private val repository: VerseRepository
){
    suspend fun invoke(): Flow<List<Verse>> =
        repository.getSavedVerses()
}