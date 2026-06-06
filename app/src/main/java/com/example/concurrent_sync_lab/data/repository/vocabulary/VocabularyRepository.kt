package com.example.concurrent_sync_lab.data.repository.vocabulary

import com.example.concurrent_sync_lab.feature.wordbook.WordCardUiModel

interface VocabularyRepository {
    suspend fun getVocabularyList(): Result<List<WordCardUiModel>>
}
