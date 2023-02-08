package de.masterthesis.shared.sample

import de.masterthesis.shared.model.Task

class SampleData {

    fun getTaskList() = listOf(
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
}