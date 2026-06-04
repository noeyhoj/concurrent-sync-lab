package com.example.concurrent_sync_lab.feature.wordbook

import java.util.UUID

data class WordCardUiModel(
    val id: String = UUID.randomUUID().toString(),
    val phrasal: String = "",
    val ldiom: String = "",
    val sentence: String = "",
    val isActive: Boolean = true
)
