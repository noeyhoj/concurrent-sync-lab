package com.example.concurrent_sync_lab.data.dto.userprofile

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoDto(
    val consecutiveWritingDays: Int,
    val isVerified: Boolean,
    val nickname: String,
    val totalDiaryCount: Int
)
