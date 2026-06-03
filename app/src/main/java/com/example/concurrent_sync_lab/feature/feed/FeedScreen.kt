package com.example.concurrent_sync_lab.feature.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedScreen(
    feedUiState: FeedUiState,
    modifier: Modifier = Modifier
) {
    var uiState by remember { mutableStateOf(feedUiState) }

    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        FeedSearchBar()
        FeedButtonBar()
        FeedList(
            feedList = uiState.feedList,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
    }
}

@Composable
private fun FeedSearchBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("피드", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "검색 아이콘",
                tint = Color.DarkGray
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(color = Color.Magenta, shape = CircleShape)
            )
        }
    }
}

@Composable
private fun FeedList(
    feedList: List<FeedCardUiModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = feedList,
            key = { it.id }
        ) {
            FeedCard(
                nickname = it.userName,
                sequenceCount = it.continuousWritingCount,
                minutesAgo = 10,
                bodyText = it.bodyText,
                likeCount = it.likeCount
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
private fun FeedCard(
    nickname: String,
    sequenceCount: Int,
    minutesAgo: Int,
    bodyText: String,
    likeCount: Int
) {
    Row {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = Color.Magenta, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FeedUserBar(
                    nickname = nickname,
                    sequenceCount = sequenceCount,
                    minutesAgo = minutesAgo
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(bodyText)
            Spacer(modifier = Modifier.height(6.dp))
            FeedInfoBottomBar(
                likeCount = likeCount
            )
        }
    }
}

@Composable
private fun FeedUserBar(
    nickname: String,
    sequenceCount: Int,
    minutesAgo: Int,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(nickname, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "별 아이콘",
                tint = Color.Magenta
            )
            Text(sequenceCount.toString(), color = Color.Magenta)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text("${minutesAgo}분 전", color = Color.LightGray)
    }
    Icon(
        imageVector = Icons.Default.Menu,
        contentDescription = "메뉴 아이콘",
        tint = Color.DarkGray
    )
}

@Composable
private fun FeedButtonBar() {
    Row {
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {}
        ) {
            Text("추천")
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {}
        ) {
            Text("팔로잉")
        }
    }
}

@Composable
private fun FeedInfoBottomBar(
    likeCount: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "좋아요 아이콘",
                tint = Color.Red
            )
            Text(
                likeCount.toString(),
                color = Color.Red
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("상세보기", color = Color.LightGray)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "화살표 아이콘",
                tint = Color.LightGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FeedScreenPreview() {
    FeedScreen(
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
