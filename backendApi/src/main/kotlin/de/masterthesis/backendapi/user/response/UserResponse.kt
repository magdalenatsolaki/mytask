package de.masterthesis.backendapi.dto.user.response

import de.masterthesis.backendapi.entity.User
import java.util.*

data class UserResponse(val id: UUID, val email: String, val username: String)

fun User.toResponse() = UserResponse(
    id = id,
    email = mail,
    username = mail
)
