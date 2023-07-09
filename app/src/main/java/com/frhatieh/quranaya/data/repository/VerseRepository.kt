package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.data.model.VerseResponse
import kotlinx.coroutines.flow.Flow

interface VerseRepository {
    suspend fun getRandomVerse(fields: String): VerseResponse
    suspend fun getSavedVerses(): Flow<List<Verse>>
    suspend fun insert(verse: Verse)
    suspend fun delete(verse: Verse)
}