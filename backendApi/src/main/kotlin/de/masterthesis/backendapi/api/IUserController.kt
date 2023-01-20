package de.masterthesis.backendapi.api

import de.masterthesis.backendapi.dto.UserCreateRequest
import de.masterthesis.backendapi.dto.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.*


interface IUserController {
    @Operation(summary = "Create a User")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "User created", content = [
                    (Content(
                        mediaType = "application/json", schema = Schema(implementation = UserResponse::class)
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "409", description = "User alread exists", content = [Content()])]
    )
    @PostMapping
    fun create(@Valid @RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse>

    @Operation(summary = "Get a user by mail")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "Get created", content = [
                    (Content(
                        mediaType = "application/json",
                        array = ArraySchema(schema = Schema(implementation = UserResponse::class))
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "404", description = "Not found", content = [Content()])]
    )
    fun read(@Valid @RequestParam id: UUID): ResponseEntity<UserResponse>

    @Operation(summary = "Get a user by mail")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "Get created", content = [
                    (Content(
                        mediaType = "application/json", schema = Schema(implementation = UserResponse::class)
                    ))]
            ),
            ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
            ApiResponse(responseCode = "404", description = "Not found", content = [Content()])]
    )
    fun readAll(): ResponseEntity<List<UserResponse>>
}