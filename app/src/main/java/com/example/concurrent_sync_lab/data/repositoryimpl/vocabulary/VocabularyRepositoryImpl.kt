package com.example.concurrent_sync_lab.data.repositoryimpl.vocabulary

import com.example.concurrent_sync_lab.data.repository.vocabulary.VocabularyRepository
import com.example.concurrent_sync_lab.data.service.vocabulary.VocabularyService
import com.example.concurrent_sync_lab.feature.vocabulary.VocabularyUiModel

class VocabularyRepositoryImpl(
    val service: VocabularyService
) : VocabularyRepository {
    override suspend fun getVocabularyList(): Result<List<VocabularyUiModel>> {
        return runCatching {
            val response = service.getVocabulary()

            response.map {
                VocabularyUiModel(
                    id = it.key,
                    phrasal = it.value.tags.getOrNull(0)?.name ?: "",
                    ldiom = it.value.tags.getOrNull(1)?.name ?: "",
                    sentence = it.value.word
                )
            }
        }
    }
}
