package com.example.concurrent_sync_lab.data.dto.home

import com.example.concurrent_sync_lab.data.dto.home.TodayStatusDto
import kotlinx.serialization.Serializable

@Serializable
data class HomeDto(
    val recommendation: RecommendationDto,
    val todayStatus: TodayStatusDto,
)
