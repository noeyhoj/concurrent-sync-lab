package com.example.concurrent_sync_lab.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppSettingDto(
    val version: String
)
