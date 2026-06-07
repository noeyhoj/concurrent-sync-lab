package com.example.concurrent_sync_lab.data.repositoryimpl.fake

import com.example.concurrent_sync_lab.data.repository.feed.FeedRepository
import com.example.concurrent_sync_lab.data.service.feed.FeedService
import com.example.concurrent_sync_lab.feature.feed.FeedCardUiModel

class FakeFeedRepositoryImpl(
    val service: FeedService
) : FeedRepository {
    override suspend fun getFeeds(): Result<List<FeedCardUiModel>> {
        return Result.failure(Exception("피드 목록을 불러오지 못했습니다."))
    }

}
