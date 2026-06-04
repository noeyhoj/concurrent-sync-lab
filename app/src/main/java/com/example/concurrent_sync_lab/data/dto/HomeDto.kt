package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class HomeDto(
    val recommendation: RecommendationDto,
    val todayStatus: TodayStatusDto,
)
