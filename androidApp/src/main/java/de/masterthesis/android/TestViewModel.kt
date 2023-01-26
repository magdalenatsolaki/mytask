package de.masterthesis.android

import androidx.lifecycle.ViewModel
import de.masterthesis.shared.dto.Task
import de.masterthesis.shared.listItems

class TestViewModel : ViewModel() {

    fun getSampleData(): List<Task> = listItems
}