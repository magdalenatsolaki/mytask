package de.masterthesis.backendapi.service

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.entity.TaskEntity
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun save(task: TaskEntity): TaskEntity {
        return taskRepository.save(task)
    }

}