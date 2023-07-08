package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.model.VerseResponse
import kotlinx.coroutines.flow.Flow

interface VerseRepository {
    fun getRandomVerse(fields: String): Flow<VerseResponse>
}