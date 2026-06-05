package com.example.concurrent_sync_lab.data.repositoryimpl.mypage

import com.example.concurrent_sync_lab.data.repository.mypage.AppSettingRepository
import com.example.concurrent_sync_lab.data.service.mypage.MyPageService

class AppSettingRepositoryImpl(
    val service: MyPageService
) : AppSettingRepository {
    override suspend fun getAppSetting(): String {
        return service.getAppSetting().version
    }
}
