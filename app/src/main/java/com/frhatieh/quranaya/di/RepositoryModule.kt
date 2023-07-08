package com.frhatieh.quranaya.di

import com.frhatieh.quranaya.data.datasource.RemoteDataSource
import com.frhatieh.quranaya.data.repository.VerseRepository
import com.frhatieh.quranaya.data.repository.VerseRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideVerseRepository(
        remoteDataSource: RemoteDataSource
    ): VerseRepository =
        VerseRepositoryImp(remoteDataSource)

}