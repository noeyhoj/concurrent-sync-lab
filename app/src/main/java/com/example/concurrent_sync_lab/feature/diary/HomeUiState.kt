package com.example.concurrent_sync_lab.feature.diary

data class HomeUiState(
    val userInfoUiModel: UserInfoUiModel = UserInfoUiModel(),
    val recommendationCardUiModel: RecommendationCardUiModel = RecommendationCardUiModel(),
    val todayStatusCardUiModel: TodayStatusCardUiModel = TodayStatusCardUiModel()
)
