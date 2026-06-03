package com.example.concurrent_sync_lab.feature.diary

import java.time.LocalDate

data class DiaryUiState(
    val userName: String = "",
    val totalWritingCount: Int = 0,
    val continuousWritingCount: Int = 0,
    val nowDate: LocalDate = LocalDate.now(),
    val dailySubject: String = ""
)
