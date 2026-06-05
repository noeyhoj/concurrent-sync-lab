package com.example.concurrent_sync_lab.feature.wordbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrent_sync_lab.data.repositoryimpl.vocabulary.VocabularyRepositoryImpl
import com.example.concurrent_sync_lab.data.service.RetrofitService
import com.example.concurrent_sync_lab.data.service.vocabulary.VocabularyService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WordBookViewModel : ViewModel() {
    private val vocabularyService = RetrofitService.retrofit.create(VocabularyService::class.java)
    private val vocabularyRepository = VocabularyRepositoryImpl(vocabularyService)

    private val _uiState = MutableStateFlow<WordBookUiState>(WordBookUiState())
    val uiState: StateFlow<WordBookUiState> = _uiState.asStateFlow()

    init {
        getVocabulary()
    }

    fun getVocabulary() {
        viewModelScope.launch {
            val vocabulary = vocabularyRepository.getVocabularyList()
            _uiState.update {
                it.copy(
                    wordList = vocabulary
                )
            }
        }
    }

    fun updateIsActive(targetId: String) {
        _uiState.update {
            it.copy(
                wordList = it.wordList.map { word ->
                    if (word.id == targetId) {
                        word.copy(
                            isActive = !word.isActive
                        )
                    } else {
                        word
                    }
                }
            )
        }
    }
}
