package de.masterthesis.backendapi.dto.user.request

import de.masterthesis.backendapi.entity.User
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email

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

fun UserCreateRequest.toEntity() = User(username = email, mail = email)
