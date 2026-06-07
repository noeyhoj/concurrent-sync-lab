package com.example.concurrent_sync_lab.data.dto.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedDto(
    val authorName: String,
    val content: String,
    val continuousWritingCount: Int,
    val likeCount: Int,
    val timeAgo: String
)
