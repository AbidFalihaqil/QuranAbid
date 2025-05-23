package com.example.quranabid.ui.theme.surahlist

import androidx.lifecycle.*
import com.example.quranabid.data.QuranRepository
import com.example.quranabid.data.model.Surah
import kotlinx.coroutines.launch

class SurahListViewModel : ViewModel() {

    private val repository = QuranRepository()

    private val _surahList = MutableLiveData<List<Surah>>()
    val surahList: LiveData<List<Surah>> = _surahList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun fetchSurahList() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.getAllSurahs()
                if (response.isSuccessful) {
                    _surahList.value = response.body()?.data ?: emptyList()
                    _error.value = null
                } else {
                    _error.value = "Gagal memuat surah."
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}