package com.example.concurrent_sync_lab.data.service.home

import com.example.concurrent_sync_lab.data.dto.home.RecommendationDto
import com.example.concurrent_sync_lab.data.dto.home.TodayStatusDto
import retrofit2.http.GET

interface HomeService {
    @GET("home/recommendation.json")
    suspend fun getRecommendation(): RecommendationDto

    @GET("home/todayStatus.json")
    suspend fun getTodayStatus(): TodayStatusDto
}
