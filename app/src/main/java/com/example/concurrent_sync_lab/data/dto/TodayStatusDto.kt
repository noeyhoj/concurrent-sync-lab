package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodayStatusDto(
    val dateString: String,
    val timeLeft: String,
    val writingStatus: String
)
