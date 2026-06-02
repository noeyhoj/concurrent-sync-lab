package com.example.concurrent_sync_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.concurrent_sync_lab.common.BottomNavigationBar
import com.example.concurrent_sync_lab.feature.diary.DiaryScreen
import com.example.concurrent_sync_lab.ui.theme.ConcurrentsynclabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConcurrentsynclabTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(
                        modifier = Modifier.navigationBarsPadding()
                    ) }
                ) { innerPadding ->
                    DiaryScreen(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    )
                }
            }
        }
    }
}
