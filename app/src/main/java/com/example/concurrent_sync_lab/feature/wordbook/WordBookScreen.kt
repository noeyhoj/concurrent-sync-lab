package com.example.concurrent_sync_lab.feature.wordbook

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WordBookScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar()
        WordCardList(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(10.dp)
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
private fun SearchBar() {
    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text("나의 단어장", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "검색 아이콘",
                tint = Color.LightGray
            )
            Text(
                "단어나 표현을 검색해 주세요",
                color = Color.LightGray
            )
        }
    }
}

@Composable
private fun SortBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("총 2개", color = Color.DarkGray)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "메뉴 아이콘",
                tint = Color.DarkGray
            )
            Text("최신순", color = Color.DarkGray)
        }
    }
}

@Composable
private fun WordCardList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SortBar()
        Spacer(modifier = Modifier.height(20.dp))
        Text("3월", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Column() {
            Spacer(modifier = Modifier.height(20.dp))
            WordCard(
                phrasal = "동사",
                ldiom = "명사",
                sentence = "take a breather"
            )
            Spacer(modifier = Modifier.height(20.dp))
            WordCard(
                ldiom = "명사",
                sentence = "take it one step at a time"
            )
        }
    }
}

@Composable
private fun WordCard(
    phrasal: String = "",
    ldiom: String = "",
    sentence: String = ""
) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Row {
                if (phrasal.isNotBlank()) {
                    TagCard(
                        text = phrasal,
                        textColor = Color.White,
                        modifier = Modifier
                            .background(
                                color = Color.Red,
                                shape = RoundedCornerShape(15.dp)
                            ),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TagCard(
                    text = ldiom,
                    textColor = Color.DarkGray,
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(15.dp)
                        ),
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(sentence, fontSize = 16.sp)
        }

        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "이메일 아이콘",
            tint = Color.Black
        )
    }
}

@Composable
private fun TagCard(
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 2.dp),
        color = textColor
    )
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
private fun WordBookScreenPreview() {
    WordBookScreen()
}
