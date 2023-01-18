package de.masterthesis.backendapi.dto.user.request

import de.masterthesis.backendapi.entity.User
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email

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

fun UserReadRequest.toEntity() = User(username = email, mail = email)
