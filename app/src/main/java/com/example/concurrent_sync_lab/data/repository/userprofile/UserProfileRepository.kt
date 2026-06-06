package com.example.concurrent_sync_lab.data.repository.userprofile

import com.example.concurrent_sync_lab.feature.diary.UserInfoUiModel

interface UserProfileRepository {
    suspend fun getUserInfo(userId: String): Result<UserInfoUiModel>
}
