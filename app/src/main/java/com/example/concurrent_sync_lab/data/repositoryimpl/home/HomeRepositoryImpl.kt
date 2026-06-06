package com.example.concurrent_sync_lab.data.repositoryimpl.home

import com.example.concurrent_sync_lab.data.repository.home.HomeRepository
import com.example.concurrent_sync_lab.data.service.home.HomeService
import com.example.concurrent_sync_lab.feature.diary.RecommendationCardUiModel
import com.example.concurrent_sync_lab.feature.diary.TodayStatusCardUiModel

class HomeRepositoryImpl(
    val service: HomeService
) : HomeRepository {
    override suspend fun getRecommendation(): Result<RecommendationCardUiModel> {
        return runCatching {
            val response = service.getRecommendation()

            RecommendationCardUiModel(
                title = response.title,
                topicQuestion = response.topicQuestion
            )
        }
    }

    override suspend fun getTodayStatus(): Result<TodayStatusCardUiModel> {
        return runCatching {
            val response = service.getTodayStatus()

            TodayStatusCardUiModel(
                dataString = response.dateString,
                timeLeft = response.timeLeft,
                writingStatus = response.writingStatus
            )
        }
    }
}
