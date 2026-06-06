package com.example.concurrent_sync_lab.feature.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrent_sync_lab.data.repositoryimpl.home.HomeRepositoryImpl
import com.example.concurrent_sync_lab.data.repositoryimpl.userprofile.UserProfileRepositoryImpl
import com.example.concurrent_sync_lab.data.service.RetrofitService
import com.example.concurrent_sync_lab.data.service.home.HomeService
import com.example.concurrent_sync_lab.data.service.userprofile.UserProfileService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiaryViewModel : ViewModel() {
    private val homeService = RetrofitService.retrofit.create(HomeService::class.java)
    private val userService = RetrofitService.retrofit.create(UserProfileService::class.java)
    private val homeRepository = HomeRepositoryImpl(homeService)
    private val userProfileRepository = UserProfileRepositoryImpl(userService)

    private val _uiState = MutableStateFlow<DiaryUiState>(DiaryUiState())
    val uiState: StateFlow<DiaryUiState> = _uiState.asStateFlow()

    init {
        getDiary()
    }

    fun getDiary() {
        viewModelScope.launch {
            val recommendation =
                homeRepository.getRecommendation().getOrDefault(RecommendationCardUiModel("", ""))
            val todayStatus =
                homeRepository.getTodayStatus().getOrDefault(TodayStatusCardUiModel("", "", ""))
            val userInfo = userProfileRepository.getUserInfo("haro_123")
                .getOrDefault(UserInfoUiModel("", 0, 0))
            _uiState.update {
                it.copy(
                    recommendationCardUiModel = recommendation,
                    todayStatusCardUiModel = todayStatus,
                    userInfoUiModel = userInfo
                )
            }
        }
    }
}
