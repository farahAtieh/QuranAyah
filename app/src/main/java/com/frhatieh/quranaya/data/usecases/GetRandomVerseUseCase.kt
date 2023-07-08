package com.frhatieh.quranaya.data.usecases

import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.repository.VerseRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetRandomVerseUseCase @Inject constructor(
    private val repository: VerseRepository
) {
    suspend fun invoke(fields: String): Verse =
        repository.getRandomVerse(fields).verse
}