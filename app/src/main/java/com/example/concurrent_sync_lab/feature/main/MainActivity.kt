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
import com.example.concurrent_sync_lab.feature.feed.FeedCardUiModel
import com.example.concurrent_sync_lab.feature.feed.FeedScreen
import com.example.concurrent_sync_lab.feature.feed.FeedUiState
import com.example.concurrent_sync_lab.feature.main.component.MainNavigationBar
import com.example.concurrent_sync_lab.feature.mypage.MyPageScreen
import com.example.concurrent_sync_lab.feature.mypage.MyPageUiState
import com.example.concurrent_sync_lab.feature.navigation.AppRoute
import com.example.concurrent_sync_lab.feature.wordbook.WordBookScreen
import com.example.concurrent_sync_lab.feature.wordbook.WordBookUiState
import com.example.concurrent_sync_lab.feature.wordbook.WordCardUiModel
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
                                WordBookScreen(
                                    wordBookUiState = WordBookUiState(
                                        wordList = listOf(
                                            WordCardUiModel(
                                                phrasal = "동사",
                                                ldiom = "숙어",
                                                sentence = "stay motivated"
                                            ),
                                            WordCardUiModel(
                                                phrasal = "동사",
                                                ldiom = "숙어",
                                                sentence = "stay motivated"
                                            ),
                                            WordCardUiModel(
                                                phrasal = "동사",
                                                ldiom = "숙어",
                                                sentence = "hone skills"
                                            ),
                                            WordCardUiModel(
                                                phrasal = "동사",
                                                ldiom = "",
                                                sentence = "unwind"
                                            )
                                        )
                                    ),
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                            entry<AppRoute.Feed> {
                                FeedScreen(
                                    modifier = Modifier.padding(innerPadding),
                                    feedUiState = FeedUiState(
                                        feedList = listOf(
                                            FeedCardUiModel(
                                                userName = "하로",
                                                continuousWritingCount = 2,
                                                likeCount = 10,
                                                bodyText = "The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic."
                                            ),
                                            FeedCardUiModel(
                                                userName = "커비",
                                                continuousWritingCount = 10,
                                                likeCount = 9,
                                                bodyText = "Its principal advantage is that it caches state and persists it through configuration changes."
                                            ),
                                            FeedCardUiModel(
                                                userName = "엘리",
                                                continuousWritingCount = 7,
                                                likeCount = 3,
                                                bodyText = "This means that your UI doesn't have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen."
                                            ),
                                            FeedCardUiModel(
                                                userName = "조디악",
                                                continuousWritingCount = 21,
                                                likeCount = 11,
                                                bodyText = "For more information on state holders, see the state holders guidance. Similarly, for more information on the UI layer generally, see the UI layer guidance."
                                            )
                                        )
                                    )
                                )
                            }
                            entry<AppRoute.MyPage> {
                                MyPageScreen(
                                    modifier = Modifier.padding(innerPadding),
                                    myPageUiState = MyPageUiState(
                                        userName = "하로"
                                    )
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}
