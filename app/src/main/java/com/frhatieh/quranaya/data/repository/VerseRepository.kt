package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.model.VerseResponse

interface VerseRepository {
    suspend fun getRandomVerse(fields: String): VerseResponse
}