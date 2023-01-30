package de.masterthesis.shared.dto

import de.masterthesis.shared.randomUUID

data class Task(
    var kurzbeschreibung: String,
    var erledigt: Boolean = false,
    val id: String = randomUUID()
) {
    fun isOffen(): Boolean = this.getState() == TaskState.OPEN
    fun isAbgeschlossen(): Boolean = !isOffen()

    private fun getState(): TaskState = if (!erledigt) TaskState.OPEN else TaskState.DONE
}

enum class TaskState(val state: String) {
    OPEN("offen"),
    DONE("abgeschlossen")
}