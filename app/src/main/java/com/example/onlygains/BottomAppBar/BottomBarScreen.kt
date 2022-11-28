package com.example.onlygains.BottomAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,

    val title: String,

    val icon: ImageVector
){

    object  Home:BottomBarScreen(

        route="feed",
        title="Feed",
        icon = Icons.Default.Home
    )

    object  Workouts:BottomBarScreen(

        route="workouts",
        title="Workouts",
        icon = Icons.Default.Settings
    )


}
