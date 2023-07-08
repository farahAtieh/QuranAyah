package com.frhatieh.quranaya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verse")
data class Verse(
    @PrimaryKey
    val id: Int,
    val hizb_number: Int,
    val juz_number: Int,
    val manzil_number: Int,
    val page_number: Int,
    val rub_el_hizb_number: Int,
    val ruku_number: Int,
    val sajdah_number: Int? = null,
    val text_uthmani: String,
    val verse_key: String,
    val verse_number: Int
)