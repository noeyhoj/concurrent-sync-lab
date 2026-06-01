package com.example.concurrent_sync_lab.feature.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiaryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        UserInfoBar(
            modifier = Modifier
                .background(color = Color.DarkGray)
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp)
        )
        Calendar(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
                .weight(3f)
        )
        HorizontalDivider(
            thickness = 4.dp,
            color = Color.LightGray
        )
        DailyCard(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .weight(2f)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.LightGray
        )
        NavigationBar()
    }
}

@Composable
private fun UserInfoBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = Color.Magenta, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text("하로", color = Color.White)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "총 개수 아이콘",
                    tint = Color.Cyan
                )
                Text("총 3편", color = Color.White)
                Text(" · ", color = Color.White)
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "0일 연속 작성 중 아이콘",
                    tint = Color.Red
                )
                Text("0일 연속 작성 중", color = Color.White)
            }
        }
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "알림 아이콘",
            tint = Color.White
        )
    }
}

@Composable
private fun Calendar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    )
}

@Composable
private fun DailyCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        DailyInfoCard(
            modifier = Modifier
                .fillMaxWidth()
        )
        DailySubjectCard(
            modifier = Modifier
                .background(color = Color.LightGray, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        DiaryCreateButton(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(vertical = 6.dp),
            onCreateDiaryClick = {}
        )
    }
}

@Composable
private fun DailyInfoCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("6월 1일 월요일", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(" · ", color = Color.LightGray)
            Text("미작성", color = Color.LightGray, fontSize = 12.sp)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "별 아이콘",
                tint = Color.Magenta
            )
            Text("30시간", color = Color.Magenta)
            Text(" 남았어요")
        }
    }
}

@Composable
private fun DailySubjectCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("오늘의 추천 주제", color = Color.DarkGray)
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "새로고침 아이콘",
                tint = Color.DarkGray
            )
        }
        Text("How does this month begin for you?")
    }
}

@Composable
private fun DiaryCreateButton(
    onCreateDiaryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        modifier = modifier,
        onClick = onCreateDiaryClick
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "추가 아이콘",
            tint = Color.White
        )
        Text("일기 작성하기", color = Color.White)
    }
}

@Composable
private fun NavigationBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NavIconButton(
            navIcon = Icons.Default.Home,
            navText = "홈",
            onNavClick = {}
        )
        NavIconButton(
            navIcon = Icons.Default.AccountBox,
            navText = "단어장",
            onNavClick = {}
        )
        NavIconButton(
            navIcon = Icons.Default.Info,
            navText = "피드",
            onNavClick = {}
        )
        NavIconButton(
            navIcon = Icons.Default.Person,
            navText = "마이",
            onNavClick = {}
        )
    }
}

@Composable
private fun NavIconButton(
    navIcon: ImageVector,
    navText: String,
    onNavClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onNavClick()
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = navIcon,
            contentDescription = "$navText 아이콘"
        )
        Text(navText)
    }
}

@Preview(showBackground = true)
@Composable
fun DiaryScreenPreview() {
    DiaryScreen()
}
