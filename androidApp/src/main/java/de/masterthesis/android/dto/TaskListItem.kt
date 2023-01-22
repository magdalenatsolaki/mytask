package de.masterthesis.android.dto

data class TaskListItem(
    val kurzbeschreibung: String,
    val erledigt: Boolean = false
)