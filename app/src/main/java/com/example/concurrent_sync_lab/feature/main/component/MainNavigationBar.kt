package com.example.concurrent_sync_lab.feature.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MainNavigationBar(
    onHomeClick: () -> Unit,
    onWordBookClick: () -> Unit,
    onFeedClick: () -> Unit,
    onMyPageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NavIconButton(
            navIcon = Icons.Default.Home,
            navText = "홈",
            onNavClick = onHomeClick
        )
        NavIconButton(
            navIcon = Icons.Default.AccountBox,
            navText = "단어장",
            onNavClick = onWordBookClick
        )
        NavIconButton(
            navIcon = Icons.Default.Info,
            navText = "피드",
            onNavClick = onFeedClick
        )
        NavIconButton(
            navIcon = Icons.Default.Person,
            navText = "마이",
            onNavClick = onMyPageClick
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
