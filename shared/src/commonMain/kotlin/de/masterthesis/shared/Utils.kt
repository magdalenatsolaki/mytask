package de.masterthesis.shared

import de.masterthesis.shared.model.Task

expect fun randomUUID(): String

fun getSampleData() = listOf(
    Task(
        "Einkaufen",
        true
    ),
    Task(
        "Sport"
    ),
    Task(
        "Arzt"
    ),
    Task(
        "Wäsche waschen",
        true
    ),
    Task(
        "Gassi gehen",
        true
    )
)