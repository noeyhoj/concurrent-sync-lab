package com.example.concurrent_sync_lab.data.repositoryimpl.home

import com.example.concurrent_sync_lab.data.repository.home.HomeRepository
import com.example.concurrent_sync_lab.data.service.home.HomeService
import com.example.concurrent_sync_lab.feature.diary.RecommendationCardUiModel
import com.example.concurrent_sync_lab.feature.diary.TodayStatusCardUiModel

class HomeRepositoryImpl(
    val service: HomeService
) : HomeRepository {
    override suspend fun getRecommendation(): RecommendationCardUiModel {
        return service.getRecommendation().let {
            RecommendationCardUiModel(
                title = it.title,
                topicQuestion = it.topicQuestion
            )
        }
    }

    override suspend fun getTodayStatus(): TodayStatusCardUiModel {
        return service.getTodayStatus().let {
            TodayStatusCardUiModel(
                dataString = it.dateString,
                timeLeft = it.timeLeft,
                writingStatus = it.writingStatus
            )
        }
    }
}
