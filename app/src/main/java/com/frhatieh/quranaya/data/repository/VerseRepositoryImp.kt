package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.datasource.LocalDataSource
import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import com.frhatieh.quranaya.data.model.Verse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VerseRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : VerseRepository {

    override suspend fun getRandomVerse(fields: String) =
        remoteDataSource.getRandomVerse(fields)

    override fun getFavoriteVerses(): Flow<List<Verse>> =
        localDataSource.getFavoriteVerses()

    override suspend fun insert(verse: Verse) =
        localDataSource.insert(verse)

    override suspend fun delete(verse: Verse) =
        localDataSource.delete(verse)
}