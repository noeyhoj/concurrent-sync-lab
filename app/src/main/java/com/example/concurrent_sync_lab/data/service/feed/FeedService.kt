package com.example.concurrent_sync_lab.data.service.feed

import com.example.concurrent_sync_lab.data.dto.feed.FeedDto
import retrofit2.http.GET

interface FeedService {
    @GET("/feeds.json")
    suspend fun getFeeds(): Map<String, FeedDto>
}
