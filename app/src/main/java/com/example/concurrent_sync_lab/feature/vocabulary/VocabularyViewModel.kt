package com.example.concurrent_sync_lab.feature.vocabulary

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

class VocabularyViewModel : ViewModel() {
    private val vocabularyService = RetrofitService.retrofit.create(VocabularyService::class.java)
    private val vocabularyRepository = VocabularyRepositoryImpl(vocabularyService)

    private val _uiState = MutableStateFlow<VocabularyUiState>(VocabularyUiState())
    val uiState: StateFlow<VocabularyUiState> = _uiState.asStateFlow()

    init {
        getVocabulary()
    }

    fun getVocabulary() {
        viewModelScope.launch {
            val vocabulary = vocabularyRepository.getVocabularyList().getOrDefault(emptyList())
            _uiState.update {
                it.copy(
                    vocabularyList = vocabulary
                )
            }
        }
    }

    fun updateIsActive(targetId: String) {
        _uiState.update {
            it.copy(
                vocabularyList = it.vocabularyList.map { word ->
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
