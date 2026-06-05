package com.example.concurrent_sync_lab.feature.diary

data class DiaryUiState(
    val userInfoUiModel: UserInfoUiModel = UserInfoUiModel(),
    val recommendationCardUiModel: RecommendationCardUiModel = RecommendationCardUiModel(),
    val todayStatusCardUiModel: TodayStatusCardUiModel = TodayStatusCardUiModel()
)
