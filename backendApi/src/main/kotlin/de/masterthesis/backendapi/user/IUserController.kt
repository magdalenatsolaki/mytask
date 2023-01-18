package de.masterthesis.backendapi.controller.user

import de.masterthesis.backendapi.dto.user.request.UserCreateRequest
import de.masterthesis.backendapi.dto.user.response.UserResponse
import de.masterthesis.backendapi.entity.User
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@RequestMapping("/api/users")
interface IUserController {
    @Operation(summary = "Create a User")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "User created", content = [
                    (Content(
                        mediaType = "application/json", schema = Schema(implementation = User::class)
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "409", description = "User alread exists", content = [Content()])]
    )
    @PostMapping("/")
    fun create(@Valid @RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse>

    @Operation(summary = "Get a user by mail")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "Get created", content = [
                    (Content(
                        mediaType = "application/json",
                        array = ArraySchema(schema = Schema(implementation = User::class))
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "404", description = "Not found", content = [Content()])]
    )
    @GetMapping("/{id}")
    fun read(@Valid @RequestParam id: UUID): ResponseEntity<UserResponse>

    @Operation(summary = "Get a user by mail")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "Get created", content = [
                    (Content(
                        mediaType = "application/json", schema = Schema(implementation = User::class)
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "404", description = "Not found", content = [Content()])]
    )
    @GetMapping("/")
    fun readAll(): ResponseEntity<List<UserResponse>>
}