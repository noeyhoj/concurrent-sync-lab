package com.example.concurrent_sync_lab.data.repositoryimpl.fake

import com.example.concurrent_sync_lab.data.repository.vocabulary.VocabularyRepository
import com.example.concurrent_sync_lab.data.service.vocabulary.VocabularyService
import com.example.concurrent_sync_lab.feature.wordbook.WordCardUiModel

class FakeVocabularyRepositoryImpl(
    val service: VocabularyService
) : VocabularyRepository {
    override suspend fun getVocabularyList(): Result<List<WordCardUiModel>> {
        return Result.failure(Exception("단어 목록을 불러오지 못했습니다."))
    }

}
