package com.example.concurrent_sync_lab.feature.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrent_sync_lab.data.repositoryimpl.mypage.AppSettingRepositoryImpl
import com.example.concurrent_sync_lab.data.repositoryimpl.userprofile.UserProfileRepositoryImpl
import com.example.concurrent_sync_lab.data.service.RetrofitService
import com.example.concurrent_sync_lab.data.service.mypage.MyPageService
import com.example.concurrent_sync_lab.data.service.userprofile.UserProfileService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyPageViewModel : ViewModel() {
    private val mypageService = RetrofitService.retrofit.create(MyPageService::class.java)
    private val myPageRepository = AppSettingRepositoryImpl(mypageService)

    private val userProfileService = RetrofitService.retrofit.create(UserProfileService::class.java)
    private val userProfileRepository = UserProfileRepositoryImpl(userProfileService)

    private val _uiState = MutableStateFlow<MyPageUiState>(MyPageUiState())
    val uiState: StateFlow<MyPageUiState> = _uiState.asStateFlow()

    init {
        getMyPage()
    }

    fun getMyPage() {
        viewModelScope.launch {
            val myPage = myPageRepository.getAppSetting()
            val userInfo = userProfileRepository.getUserInfo("haro_123")
            _uiState.value = MyPageUiState(
                userName = userInfo.userName,
                version = myPage
            )
        }
    }
}
