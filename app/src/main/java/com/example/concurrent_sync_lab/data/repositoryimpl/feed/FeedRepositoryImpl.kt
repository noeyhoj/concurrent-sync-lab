package com.example.concurrent_sync_lab.data.repositoryimpl.feed

import com.example.concurrent_sync_lab.data.repository.feed.FeedRepository
import com.example.concurrent_sync_lab.data.service.feed.FeedService
import com.example.concurrent_sync_lab.feature.feed.FeedCardUiModel

class FeedRepositoryImpl(
    val service: FeedService
) : FeedRepository {
    override suspend fun getFeeds(): Result<List<FeedCardUiModel>> {
        return runCatching {
            val response = service.getFeeds()

            response.map {
                FeedCardUiModel(
                    id = it.value.authorName,
                    bodyText = it.value.content,
                    userName = it.value.authorName,
                    continuousWritingCount = it.value.continuousWritingCount,
                    likeCount = it.value.likeCount,
                    timeAgo = it.value.timeAgo
                )
            }
        }
    }
}
