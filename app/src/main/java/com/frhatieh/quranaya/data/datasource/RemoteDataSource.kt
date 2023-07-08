package com.frhatieh.quranaya.data.datasource

import com.frhatieh.quranaya.data.model.VerseResponse
import com.frhatieh.quranaya.network.VerseApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val verseApiService: VerseApiService
) {

    suspend fun getRandomVerse(fields: String): VerseResponse =
        verseApiService.getRandomVerse(fields)
}