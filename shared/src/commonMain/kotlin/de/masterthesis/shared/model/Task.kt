package de.masterthesis.shared.model

import de.masterthesis.shared.randomUUID

data class Task(
    var kurzbeschreibung: String,
    var isErledigt: Boolean = false,
    val id: String = randomUUID()
) {
    fun isOffen(): Boolean = this.getState() == TaskState.OPEN
    fun isAbgeschlossen(): Boolean = !isOffen()

    private fun getState(): TaskState = if (!isErledigt) TaskState.OPEN else TaskState.DONE
}

enum class TaskState(val state: String) {
    OPEN("offen"),
    DONE("abgeschlossen")
}