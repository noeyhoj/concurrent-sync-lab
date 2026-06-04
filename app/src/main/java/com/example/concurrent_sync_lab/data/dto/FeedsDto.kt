package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FeedsDto(
    val feeds: List<FeedDto>
)
