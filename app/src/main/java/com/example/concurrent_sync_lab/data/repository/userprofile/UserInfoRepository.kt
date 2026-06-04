package com.example.concurrent_sync_lab.data.repository.userprofile

import com.example.concurrent_sync_lab.feature.diary.UserInfoUiModel

interface UserInfoRepository {
    suspend fun getUserInfo(): UserInfoUiModel
}
