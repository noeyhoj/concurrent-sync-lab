package com.example.concurrent_sync_lab.data.repositoryimpl.fake

import com.example.concurrent_sync_lab.data.repository.userprofile.UserProfileRepository
import com.example.concurrent_sync_lab.data.service.userprofile.UserProfileService
import com.example.concurrent_sync_lab.feature.diary.UserInfoUiModel

class FakeUserProfileRepositoryImpl(
    val service: UserProfileService
) : UserProfileRepository {
    override suspend fun getUserInfo(userId: String): Result<UserInfoUiModel> {
        return Result.failure(Exception("유저 정보를 불러오지 못했습니다."))
    }
}
