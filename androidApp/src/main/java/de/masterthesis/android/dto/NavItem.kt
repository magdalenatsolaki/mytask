package de.masterthesis.android.dto

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)