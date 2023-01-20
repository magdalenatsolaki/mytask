package de.masterthesis.backendapi.api

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.db.UserRepository
import de.masterthesis.backendapi.dto.UserCreateRequest
import de.masterthesis.backendapi.dto.UserResponse
import de.masterthesis.backendapi.dto.toEntity
import de.masterthesis.backendapi.dto.toResponse
import de.masterthesis.backendapi.entity.TaskEntity
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository, private val taskRepository: TaskRepository) :
    IUserController {
    @PostMapping
    override fun create(userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse> {
        val user = userRepository.save(userCreateRequest.toEntity())
        taskRepository.save(TaskEntity(title = "Title1", headline = "Headline1", content = "Content1", author = user))
        taskRepository.save(TaskEntity(title = "Title2", headline = "Headline2", content = "Content2", author = user))
        return ResponseEntity.ok(user.toResponse())
    }

    @GetMapping("/{id}")
    override fun read(@Valid @RequestParam id: UUID): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userRepository.findById(id).get().toResponse())
    }

    @GetMapping
    override fun readAll(): ResponseEntity<List<UserResponse>> {
            return ResponseEntity.ok(userRepository.findAll().map { it.toResponse() })
    }

}