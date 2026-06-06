package com.example.concurrent_sync_lab.data.repositoryimpl.userprofile

import com.example.concurrent_sync_lab.data.repository.userprofile.UserProfileRepository
import com.example.concurrent_sync_lab.data.service.userprofile.UserProfileService
import com.example.concurrent_sync_lab.feature.diary.UserInfoUiModel

class UserProfileRepositoryImpl(
    val service: UserProfileService
) : UserProfileRepository {
    override suspend fun getUserInfo(userId: String): Result<UserInfoUiModel> {
        return runCatching {
            val response = service.getUserProfile()

            response[userId]?.let {
                UserInfoUiModel(
                    userName = it.nickname,
                    totalWritingCount = it.totalDiaryCount,
                    continuousWritingCount = it.consecutiveWritingDays
                )
            } ?: throw IllegalArgumentException()
        }
    }
}
