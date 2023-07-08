package com.frhatieh.quranaya.data.datasource

import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.database.VerseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val verseDao: VerseDao
) {
    fun getFavoriteVerses(): Flow<List<Verse>> =
        verseDao.getFavoriteVerses()

    suspend fun insert(verse: Verse) =
        withContext(Dispatchers.IO) {
            verseDao.insert(verse)
        }

    suspend fun delete(verse: Verse) =
        withContext(Dispatchers.IO) {
            verseDao.delete(verse)
        }
}