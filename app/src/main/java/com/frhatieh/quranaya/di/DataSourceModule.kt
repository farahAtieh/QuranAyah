package com.frhatieh.quranaya.di

import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import com.frhatieh.quranaya.network.VerseApiService
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


}