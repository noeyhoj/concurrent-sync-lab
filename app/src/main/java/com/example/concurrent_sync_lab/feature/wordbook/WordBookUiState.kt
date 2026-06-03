package com.example.concurrent_sync_lab.feature.wordbook

data class WordBookUiState(
    val wordList: List<WordCardUiModel> = emptyList()
)
