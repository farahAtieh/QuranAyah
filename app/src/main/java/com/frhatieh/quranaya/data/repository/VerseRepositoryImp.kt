package com.frhatieh.quranaya.data.repository

import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import com.frhatieh.quranaya.data.model.VerseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VerseRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : VerseRepository {

    override fun getRandomVerse(fields: String): Flow<VerseResponse> = flow {
        emit(remoteDataSource.getRandomVerse(fields))
    }
}