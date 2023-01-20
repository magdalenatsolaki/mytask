package de.masterthesis.backendapi.db

import de.masterthesis.backendapi.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<TaskEntity, Long> {
    fun findAllByOrderByAddedAtDesc(): Iterable<TaskEntity>
}