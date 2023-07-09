package com.frhatieh.quranaya.shared.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.frhatieh.quranaya.data.model.Verse
import kotlinx.coroutines.flow.Flow

@Dao
interface VerseDao {

    @Query("SELECT * FROM verse")
    fun getSavedVerses(): Flow<List<Verse>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(verse: Verse)

    @Delete
    suspend fun delete(verse: Verse)
}