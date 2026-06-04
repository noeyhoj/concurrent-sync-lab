package com.example.concurrent_sync_lab.data.repository.home

import com.example.concurrent_sync_lab.feature.diary.RecommendationCardUiModel
import com.example.concurrent_sync_lab.feature.diary.TodayStatusCardUiModel

interface HomeRepository {
    suspend fun getRecommendation(): RecommendationCardUiModel
    suspend fun getTodayStatus(): TodayStatusCardUiModel
}
