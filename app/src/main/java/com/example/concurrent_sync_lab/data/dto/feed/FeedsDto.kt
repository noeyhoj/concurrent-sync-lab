package com.example.concurrent_sync_lab.data.dto.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedsDto(
    val feeds: Map<String,FeedDto>
)
