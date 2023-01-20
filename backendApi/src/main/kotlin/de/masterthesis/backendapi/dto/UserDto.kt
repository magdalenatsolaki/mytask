package de.masterthesis.backendapi.dto

import de.masterthesis.backendapi.entity.UserEntity
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import java.util.*

@Schema(description = "Model for User")
data class UserCreateRequest(
    @field:Schema(
        description = "The Username equals to the Mailadress",
        example = "firstname.secondname@domain.com",
        type = "string"
    )
    @Email(message = "Email should be valid")
    val email: String
)

fun UserCreateRequest.toEntity() = UserEntity(username = email, mail = email)

@Schema(description = "Model for User")
data class UserReadRequest(
    @field:Schema(
        description = "Mailadress",
        example = "firstname.secondname@domain.com",
        type = "string"
    )
    @Email(message = "Email should be valid")
    val email: String
)

fun UserReadRequest.toEntity() = UserEntity(username = email, mail = email)


data class UserResponse(val id: UUID, val email: String, val username: String)

fun UserEntity.toResponse() = UserResponse(id = id, email = mail, username = mail)
