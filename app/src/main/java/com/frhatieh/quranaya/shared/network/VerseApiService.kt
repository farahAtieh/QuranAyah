package com.frhatieh.quranaya.shared.network

import com.frhatieh.quranaya.data.model.VerseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VerseApiService {
    @GET("verses/random")
    suspend fun getRandomVerse(
        @Query("fields") fields: String): VerseResponse
}