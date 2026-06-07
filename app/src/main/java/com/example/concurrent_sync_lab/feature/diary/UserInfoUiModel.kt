package com.example.concurrent_sync_lab.feature.diary

data class UserInfoUiModel(
    val userName: String = "",
    val totalWritingCount: Int = 0,
    val continuousWritingCount: Int = 0
)
