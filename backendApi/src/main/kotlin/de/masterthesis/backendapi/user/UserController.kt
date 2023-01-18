package de.masterthesis.backendapi.controller.user

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.db.UserRepository
import de.masterthesis.backendapi.dto.user.request.UserCreateRequest
import de.masterthesis.backendapi.dto.user.request.toEntity
import de.masterthesis.backendapi.dto.user.response.UserResponse
import de.masterthesis.backendapi.dto.user.response.toResponse
import de.masterthesis.backendapi.entity.Task
import io.swagger.v3.oas.annotations.parameters.RequestBody
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserController(private val userRepository: UserRepository, private val taskRepository: TaskRepository) :
    IUserController {
    override fun create(@Valid @RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse> {
        val user = userRepository.save(userCreateRequest.toEntity())
        taskRepository.save(Task(title = "Title1", headline = "Headline1", content = "Content1", author = user))
        taskRepository.save(Task(title = "Title2", headline = "Headline2", content = "Content2", author = user))
        return ResponseEntity.ok(user.toResponse())
    }

    override fun read(id: UUID): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userRepository.findById(id).get().toResponse())
    }

    override fun readAll(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok(userRepository.findAll().map { it.toResponse() })
    }

}