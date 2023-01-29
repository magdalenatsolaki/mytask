package de.masterthesis.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.masterthesis.shared.dto.Task
import de.masterthesis.shared.listItems

class SearchViewModel : ViewModel() {
    private var _list = MutableLiveData<List<Task>>()
    val list: LiveData<List<Task>>
        get() = _list

    private fun taskListData(): List<Task> {
        return listItems
    }

    init {
        loadActors()
    }

    fun loadActors() {
        _list.postValue(taskListData())
    }

    fun performQuery(query: String) {
        val filteredList = ArrayList<Task>()
        taskListData().forEach { task ->
            if (task.kurzbeschreibung.lowercase().contains(query.lowercase())) {
                filteredList.add(Task(task.kurzbeschreibung))
            }
        }
        _list.postValue(filteredList)
    }
}
