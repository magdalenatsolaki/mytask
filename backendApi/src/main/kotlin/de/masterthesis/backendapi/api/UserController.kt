package de.masterthesis.backendapi.api

import de.masterthesis.backendapi.dto.UserCreateRequest
import de.masterthesis.backendapi.dto.UserResponse
import de.masterthesis.backendapi.dto.toEntity
import de.masterthesis.backendapi.dto.toResponse
import de.masterthesis.backendapi.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) :
    IUserController {
    @PostMapping
    override fun create(userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse> {
        val user = userService.save(userCreateRequest.toEntity())
        return ResponseEntity.ok(user.toResponse())
    }

    @GetMapping("/{id}")
    override fun read(@Valid @PathVariable id: UUID): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.findById(id))
    }

    @GetMapping
    override fun readAll(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok(userService.findAll())
    }

}