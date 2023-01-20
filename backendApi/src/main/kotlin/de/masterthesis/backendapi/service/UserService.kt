package de.masterthesis.backendapi.service

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.db.UserRepository
import de.masterthesis.backendapi.dto.UserResponse
import de.masterthesis.backendapi.dto.toResponse
import de.masterthesis.backendapi.entity.TaskEntity
import de.masterthesis.backendapi.entity.UserEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository, private val taskRepository: TaskRepository) {
    fun save(user: UserEntity): UserEntity {
        val user = userRepository.save(user)
        taskRepository.save(TaskEntity(title = "Title1", headline = "Headline1", content = "Content1", author = user))
        taskRepository.save(TaskEntity(title = "Title2", headline = "Headline2", content = "Content2", author = user))
        return user
    }


    fun findById(id: UUID): UserResponse = userRepository.findById(id).get().toResponse()

    fun findAll(): List<UserResponse> = userRepository.findAll().map { it.toResponse() }

}