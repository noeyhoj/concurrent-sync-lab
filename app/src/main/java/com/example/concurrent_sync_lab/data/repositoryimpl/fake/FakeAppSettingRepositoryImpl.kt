package com.example.concurrent_sync_lab.data.repositoryimpl.fake

import com.example.concurrent_sync_lab.data.repository.mypage.AppSettingRepository
import com.example.concurrent_sync_lab.data.service.mypage.MyPageService

class FakeAppSettingRepositoryImpl(
    val service: MyPageService
) : AppSettingRepository {
    override suspend fun getAppSetting(): Result<String> {
        return Result.failure(Exception("앱 설정 정보를 불러오지 못했습니다."))
    }
}
