package com.example.concurrent_sync_lab.data.repository.vocabulary

import com.example.concurrent_sync_lab.feature.vocabulary.VocabularyUiModel

interface VocabularyRepository {
    suspend fun getVocabularyList(): Result<List<VocabularyUiModel>>
}
