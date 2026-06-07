package com.example.concurrent_sync_lab.data.dto.vocabulary

import kotlinx.serialization.Serializable

@Serializable
data class VocabularyDto(
    val vocabulary: Map<String,VocabDto>
)
