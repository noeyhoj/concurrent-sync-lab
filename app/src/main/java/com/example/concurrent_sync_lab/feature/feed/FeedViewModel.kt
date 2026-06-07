package com.example.concurrent_sync_lab.feature.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrent_sync_lab.data.repositoryimpl.feed.FeedRepositoryImpl
import com.example.concurrent_sync_lab.data.service.RetrofitService
import com.example.concurrent_sync_lab.data.service.feed.FeedService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val feedService = RetrofitService.retrofit.create(FeedService::class.java)
    private val feedRepository = FeedRepositoryImpl(feedService)

    private val _uiState = MutableStateFlow<FeedUiState>(FeedUiState())
    val uiState: StateFlow<FeedUiState> = _uiState.asStateFlow()

    init {
        getFeed()
    }

    fun getFeed() {
        viewModelScope.launch {
            val feed = feedRepository.getFeeds().getOrDefault(emptyList())
            _uiState.value = FeedUiState(
                feedList = feed
            )
        }
    }
}
