package com.example.concurrent_sync_lab.feature.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppRoute : NavKey {
    @Serializable
    data object Home : AppRoute

    @Serializable
    data object WordBook : AppRoute

    @Serializable
    data object Feed : AppRoute

    @Serializable
    data object MyPage : AppRoute
}
