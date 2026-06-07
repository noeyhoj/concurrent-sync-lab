package com.example.concurrent_sync_lab.data.service.mypage

import com.example.concurrent_sync_lab.data.dto.mypage.AppSettingDto
import retrofit2.http.GET

interface MyPageService {
    @GET("appSettings.json")
    suspend fun getAppSetting(): AppSettingDto
}
