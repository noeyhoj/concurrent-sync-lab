package com.example.concurrent_sync_lab.data.repositoryimpl.feed

import com.example.concurrent_sync_lab.data.repository.feed.FeedRepository
import com.example.concurrent_sync_lab.data.service.feed.FeedService
import com.example.concurrent_sync_lab.feature.feed.FeedCardUiModel

class FeedRepositoryImpl(
    val service: FeedService
) : FeedRepository {
    override suspend fun getFeeds(): List<FeedCardUiModel> {
        return service.getFeeds().map {
            FeedCardUiModel(
                id = it.key,
                timeAgo = it.value.timeAgo,
                userName = it.value.authorName,
                continuousWritingCount = it.value.continuousWritingCount,
                likeCount = it.value.likeCount,
                bodyText = it.value.content
            )
        }
    }
}
