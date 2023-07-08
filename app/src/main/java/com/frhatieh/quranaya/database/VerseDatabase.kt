package com.frhatieh.quranaya.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frhatieh.quranaya.data.model.Verse

@Database(entities = [Verse::class], version = 1, exportSchema = false)
abstract class VerseDatabase: RoomDatabase() {

    abstract fun verseDao(): VerseDao
}