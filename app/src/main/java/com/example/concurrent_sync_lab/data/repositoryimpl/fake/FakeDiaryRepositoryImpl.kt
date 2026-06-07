package com.example.concurrent_sync_lab.data.repositoryimpl.fake

import com.example.concurrent_sync_lab.data.repository.home.HomeRepository
import com.example.concurrent_sync_lab.data.service.home.HomeService
import com.example.concurrent_sync_lab.feature.diary.RecommendationCardUiModel
import com.example.concurrent_sync_lab.feature.diary.TodayStatusCardUiModel

class FakeDiaryRepositoryImpl(
    val service: HomeService
) : HomeRepository {
    override suspend fun getRecommendation(): Result<RecommendationCardUiModel> {
        return Result.failure(Exception("최근 주제에서 예외를 던짐"))
    }

    override suspend fun getTodayStatus(): Result<TodayStatusCardUiModel> {
        return Result.failure(Exception("오늘 상태에서 예외를 던짐"))
    }
}
