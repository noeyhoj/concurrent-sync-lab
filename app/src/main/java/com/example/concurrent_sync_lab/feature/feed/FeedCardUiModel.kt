package com.example.concurrent_sync_lab.feature.feed

import java.util.UUID

data class FeedCardUiModel(
    val id: String = UUID.randomUUID().toString(),
    val userName: String = "",
    val continuousWritingCount: Int = 0,
    val likeCount: Int = 0,
    val bodyText: String = ""
)
