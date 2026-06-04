package com.example.concurrent_sync_lab.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class RecommendationDto(
    val title: String,
    val topicQuestion: String
)
