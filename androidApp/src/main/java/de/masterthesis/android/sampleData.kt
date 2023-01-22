package de.masterthesis.android

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import de.masterthesis.android.dto.NavItem
import de.masterthesis.android.dto.TaskListItem


val navItems = listOf(
    NavItem(
        name = "Home",
        route = "home",
        icon = Icons.Rounded.Home,
    ),
    NavItem(
        name = "Create",
        route = "add",
        icon = Icons.Rounded.AddCircle,
    ),
    NavItem(
        name = "Settings",
        route = "settings",
        icon = Icons.Rounded.Settings,
    ),
)

val listItems = listOf(
    TaskListItem(
        "",
    ),
    TaskListItem(
        "Einkaufen",
        true
    ),
    TaskListItem(
        "Sport"
    ),
    TaskListItem(
        "Arzt"
    ),
    TaskListItem(
        "Wäsche waschen",
        true
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen",
        true
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
    TaskListItem(
        "Gassi gehen"
    ),
)