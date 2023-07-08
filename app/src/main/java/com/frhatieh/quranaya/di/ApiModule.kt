package com.frhatieh.quranaya.di

import com.frhatieh.quranaya.network.VerseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideVerseApiService(retrofit: Retrofit): VerseApiService =
        retrofit.create(VerseApiService::class.java)
}