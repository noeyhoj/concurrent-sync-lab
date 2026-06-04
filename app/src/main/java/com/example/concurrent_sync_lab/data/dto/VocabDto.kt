package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class VocabDto(
    val createdAt: Long,
    val monthGroup: String,
    val tags: List<TagDto>,
    val word: String
)
