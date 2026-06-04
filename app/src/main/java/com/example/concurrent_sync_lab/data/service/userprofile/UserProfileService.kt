package com.example.concurrent_sync_lab.data.service.userprofile

import com.example.concurrent_sync_lab.data.dto.userprofile.UserInfoDto
import retrofit2.http.GET

interface UserProfileService {
    @GET("userProfile.json")
    suspend fun getUserProfile(): Map<String, UserInfoDto>
}
