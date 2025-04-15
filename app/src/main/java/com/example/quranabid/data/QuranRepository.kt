package com.example.quranabid.data
import com.example.quranabid.data.network.RetrofitInstance

class QuranRepository {
    suspend fun getAllSurahs() = RetrofitInstance.api.getAllSurahs()
    suspend fun getSurahDetail(number: Int) = RetrofitInstance.api.getSurahDetail(number)
}