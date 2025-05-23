package com.example.quranabid.data.network

import com.example.quranabid.data.model.SurahResponse
import com.example.quranabid.data.model.SurahDetailEditionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApiService {
    @GET("v1/surah")
    suspend fun getAllSurahs(): Response<SurahResponse>

    @GET("v1/surah/{number}/editions/quran-uthmani,id.indonesian")
    suspend fun getSurahDetail(
        @Path("number") number: Int
    ): Response<SurahDetailEditionResponse>
}