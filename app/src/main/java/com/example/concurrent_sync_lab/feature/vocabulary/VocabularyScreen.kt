package com.example.concurrent_sync_lab.feature.vocabulary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WordBookScreen(
    viewModel: VocabularyViewModel = VocabularyViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar()
        VocabularyList(
            vocabularyList = uiState.value.vocabularyList,
            updateIsActive = { viewModel.updateIsActive(it) },
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
private fun SortBar(
    vocabularyListCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("총 ${vocabularyListCount}개", color = Color.DarkGray)
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
private fun VocabularyList(
    vocabularyList: List<VocabularyUiModel>,
    updateIsActive: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            SortBar(
                vocabularyListCount = vocabularyList.size,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("3월", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        items(
            items = vocabularyList,
            key = { it.id }
        ) {
            WordCard(
                phrasal = it.phrasal,
                ldiom = it.ldiom,
                sentence = it.sentence,
                isActive = it.isActive,
                updateIsActive = { updateIsActive(it.id) }
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun WordCard(
    phrasal: String,
    ldiom: String ,
    sentence: String,
    isActive: Boolean,
    updateIsActive: () -> Unit
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
                TagCard(
                    text = phrasal,
                    textColor = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Red,
                            shape = RoundedCornerShape(15.dp)
                        ),
                )
                if (ldiom.isNotBlank()) {
                    Spacer(modifier = Modifier.width(8.dp))
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
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(sentence, fontSize = 16.sp)
        }
        IconButton(
            onClick = {
                updateIsActive()
            }
        ) {
            if (isActive) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "이메일 아이콘",
                    tint = Color.Black
                )
            } else {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "이메일 아이콘",
                    tint = Color.LightGray
                )
            }
        }
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

@Preview(showBackground = true)
@Composable
private fun WordBookScreenPreview() {
    WordBookScreen()
}
