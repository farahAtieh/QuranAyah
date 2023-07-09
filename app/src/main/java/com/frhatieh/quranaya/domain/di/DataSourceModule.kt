package com.frhatieh.quranaya.domain.di

import com.frhatieh.quranaya.data.datasource.LocalDataSource
import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import com.frhatieh.quranaya.shared.database.VerseDao
import com.frhatieh.quranaya.shared.network.VerseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideRemoteDataSource(
        verseApiService: VerseApiService
    ): RemoteDataSource = RemoteDataSource(verseApiService)

    @Provides
    fun provideLocalDataSource(
        verseDao: VerseDao
    ): LocalDataSource = LocalDataSource(verseDao)
}