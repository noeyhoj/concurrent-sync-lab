package com.example.concurrent_sync_lab.feature.feed

data class FeedCardUiModel(
    val id: String = "",
    val timeAgo: String = "",
    val userName: String = "",
    val continuousWritingCount: Int = 0,
    val likeCount: Int = 0,
    val bodyText: String = ""
)
