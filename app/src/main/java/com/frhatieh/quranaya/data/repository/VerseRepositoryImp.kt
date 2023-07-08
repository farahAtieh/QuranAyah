package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import javax.inject.Inject

class VerseRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : VerseRepository {

    override suspend fun getRandomVerse(fields: String) =
        remoteDataSource.getRandomVerse(fields)
}