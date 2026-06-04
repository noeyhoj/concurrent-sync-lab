package com.example.concurrent_sync_lab.data.dto.userprofile

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDto(
    val userInfo: Map<String, UserInfoDto>
)
