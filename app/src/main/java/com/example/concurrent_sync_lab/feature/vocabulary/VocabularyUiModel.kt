package com.example.concurrent_sync_lab.feature.vocabulary

import java.util.UUID

data class VocabularyUiModel(
    val id: String = UUID.randomUUID().toString(),
    val phrasal: String = "",
    val ldiom: String = "",
    val sentence: String = "",
    val isActive: Boolean = true
)
