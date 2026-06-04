package com.example.concurrent_sync_lab.data.service.vocabulary

import com.example.concurrent_sync_lab.data.dto.vocabulary.VocabDto
import retrofit2.http.GET

interface VocabularyService {
    @GET("vocabulary.json")
    suspend fun getVocabulary(): Map<String, VocabDto>
}
