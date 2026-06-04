package com.example.concurrent_sync_lab.data.service.home

import com.example.concurrent_sync_lab.data.dto.home.RecommendationDto
import com.example.concurrent_sync_lab.data.dto.home.TodayStatusDto
import retrofit2.http.GET

interface HomeService {
    @GET("home.json/recommendation")
    suspend fun getRecommendation(): RecommendationDto

    @GET("home.json/todayStatus")
    suspend fun getTodayStatus(): TodayStatusDto
}
