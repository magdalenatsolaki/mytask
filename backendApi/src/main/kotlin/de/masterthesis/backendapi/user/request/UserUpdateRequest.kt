package de.masterthesis.backendapi.dto.user.request

import de.masterthesis.backendapi.entity.User
import java.util.*

data class UserUpdateRequest(val email: String)

fun UserUpdateRequest.toEntity(id: UUID) = User(id = id, mail = email, username = email)
