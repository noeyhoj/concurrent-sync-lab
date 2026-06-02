package com.example.concurrent_sync_lab.feature.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
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
fun MyPageScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(10.dp)
                .fillMaxSize()
                .weight(1f)
        ) {
            Text("마이페이지", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            UserInfoCard(
                username = "하로",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            SettingCard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
        }
        NavigationBar()

    }

}

@Composable
private fun UserInfoCard(
    username: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(color = Color.Magenta, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(username)
            }
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "수정 아이콘",
                tint = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = {},
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(6.dp)
                )
                .fillMaxWidth()
        ) {
            Text("나의 피드", color = Color.White)
        }
    }
}

@Composable
private fun SettingCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    SettingCard(
                        title = "알림 설정",
                        imageVector = Icons.Default.Notifications,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SettingCard(
                        title = "차단한 유저",
                        imageVector = Icons.Default.Clear,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SettingCard(
                        title = "고객센터",
                        imageVector = Icons.Default.AccountBox,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SettingCard(
                        title = "개인정보 처리방침 및 이용약관",
                        imageVector = Icons.Default.Email,
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            SettingCardTwo(
                title = "버전 정보",
                imageVector = Icons.Default.CheckCircle,
                subText = "2.4.6"
            )
            Spacer(modifier = Modifier.height(20.dp))
            SettingCardTwo(
                title = "오픈소스 라이선스",
                imageVector = Icons.Default.CheckCircle,
            )
            Spacer(modifier = Modifier.height(20.dp))
            SettingCardTwo(
                title = "로그아웃",
                imageVector = Icons.Default.PlayArrow,
            )
        }
    }
}

@Composable
private fun SettingCard(
    title: String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Icon(
                imageVector = imageVector,
                contentDescription = "$title 아이콘",
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(title, color = Color.DarkGray)
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "오른쪽 화살표 아이콘"
        )
    }
}

@Composable
private fun SettingCardTwo(
    title: String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    subText: String = "",
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "${title} 아이콘",
                tint = Color.DarkGray
            )
            Text(title)

        }
        if (subText.isNotBlank()) Text(subText)
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
private fun MyPageScreenPreview() {
    MyPageScreen()
}
