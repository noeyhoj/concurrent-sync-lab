package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoDto(
    val consecutiveWritingCount: Int,
    val isVerified: Boolean,
    val nickname: String,
    val totalDailyCount: Int
)
