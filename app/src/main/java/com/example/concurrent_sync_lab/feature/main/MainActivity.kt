package com.example.concurrent_sync_lab.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.concurrent_sync_lab.feature.diary.DiaryScreen
import com.example.concurrent_sync_lab.feature.diary.DiaryUiState
import com.example.concurrent_sync_lab.feature.feed.FeedScreen
import com.example.concurrent_sync_lab.feature.main.component.MainNavigationBar
import com.example.concurrent_sync_lab.feature.mypage.MyPageScreen
import com.example.concurrent_sync_lab.feature.navigation.AppRoute
import com.example.concurrent_sync_lab.feature.wordbook.WordBookScreen
import com.example.concurrent_sync_lab.ui.theme.ConcurrentsynclabTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val backStack = rememberNavBackStack(AppRoute.Home)

            ConcurrentsynclabTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MainNavigationBar(
                            modifier = Modifier.navigationBarsPadding(),
                            onHomeClick = {
                                backStack.add(AppRoute.Home)
                                backStack.removeFirstOrNull()
                            },
                            onWordBookClick = {
                                backStack.add(AppRoute.WordBook)
                                backStack.removeFirstOrNull()
                            },
                            onFeedClick = {
                                backStack.add(AppRoute.Feed)
                                backStack.removeFirstOrNull()
                            },
                            onMyPageClick = {
                                backStack.add(AppRoute.MyPage)
                                backStack.removeFirstOrNull()
                            }
                        )
                    }
                ) { innerPadding ->
                    NavDisplay(
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        entryProvider = entryProvider {
                            entry<AppRoute.Home> {
                                DiaryScreen(
                                    modifier = Modifier.padding(innerPadding),
                                    diaryUiState = DiaryUiState(
                                        userName = "하로",
                                        totalWritingCount = 10,
                                        continuousWritingCount = 2,
                                        nowDate = LocalDate.now(),
                                        dailySubject = "How does this month begin for you?"
                                    )
                                )
                            }
                            entry<AppRoute.WordBook> {
                                WordBookScreen(modifier = Modifier.padding(innerPadding))
                            }
                            entry<AppRoute.Feed> {
                                FeedScreen(modifier = Modifier.padding(innerPadding))
                            }
                            entry<AppRoute.MyPage> {
                                MyPageScreen(modifier = Modifier.padding(innerPadding))
                            }
                        }
                    )
                }
            }
        }
    }
}
