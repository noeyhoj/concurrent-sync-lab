package com.example.concurrent_sync_lab.data.repository.mypage

interface AppSettingRepository {
    suspend fun getAppSetting(): Result<String>
}
