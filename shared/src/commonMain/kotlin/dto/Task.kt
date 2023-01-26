package de.masterthesis.shared.dto

data class Task(
    val kurzbeschreibung: String,
    var erledigt: Boolean = false
) {
    fun isOffen(): Boolean = this.getState() == State.OPEN
    fun isAbgeschlossen(): Boolean = !isOffen()

    private fun getState(): State = if (!erledigt) State.OPEN else State.DONE
}

enum class State(val state: String) {
    OPEN("offen"),
    DONE("abgeschlossen")
}