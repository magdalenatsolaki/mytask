package de.masterthesis.backendapi.db

import de.masterthesis.backendapi.entity.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long> {
    fun findBySlug(slug: String): Task?
    fun findAllByOrderByAddedAtDesc(): Iterable<Task>
}