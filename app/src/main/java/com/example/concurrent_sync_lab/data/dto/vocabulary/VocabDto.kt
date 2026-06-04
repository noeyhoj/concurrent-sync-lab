package com.example.concurrent_sync_lab.data.dto.vocabulary

import com.example.concurrent_sync_lab.data.dto.vocabulary.TagDto
import kotlinx.serialization.Serializable

@Serializable
data class VocabDto(
    val createdAt: Long,
    val monthGroup: String,
    val tags: List<TagDto>,
    val word: String
)
