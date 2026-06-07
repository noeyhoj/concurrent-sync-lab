package com.example.concurrent_sync_lab.data.repository.feed

import com.example.concurrent_sync_lab.feature.feed.FeedCardUiModel

interface FeedRepository {
    suspend fun getFeeds(): Result<List<FeedCardUiModel>>
}
