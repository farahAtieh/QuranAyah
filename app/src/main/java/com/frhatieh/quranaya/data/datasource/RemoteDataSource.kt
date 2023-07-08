package com.frhatieh.quranaya.data.datasource

import com.frhatieh.quranaya.data.model.VerseResponse
import com.frhatieh.quranaya.network.VerseApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val verseApiService: VerseApiService
) {

    suspend fun getRandomVerse(fields: String): VerseResponse =
        withContext(Dispatchers.IO) {
            verseApiService.getRandomVerse(fields)
        }
}