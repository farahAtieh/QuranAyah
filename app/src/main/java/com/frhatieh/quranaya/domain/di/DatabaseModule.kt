package com.frhatieh.quranaya.domain.di

import android.content.Context
import androidx.room.Room
import com.frhatieh.quranaya.shared.database.VerseDao
import com.frhatieh.quranaya.shared.database.VerseDatabase
import com.frhatieh.quranaya.shared.util.Verse_Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): VerseDatabase =
        Room.databaseBuilder(
            context,
            VerseDatabase::class.java,
            Verse_Database
        )
            .allowMainThreadQueries()
            .build()


    @Singleton
    @Provides
    fun provideVerseDao(verseDatabase: VerseDatabase): VerseDao =
        verseDatabase.verseDao()
}