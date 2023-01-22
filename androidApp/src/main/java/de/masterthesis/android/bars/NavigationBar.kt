package de.masterthesis.android.bars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import de.masterthesis.android.navItems


@Composable
fun NavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

