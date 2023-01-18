package de.masterthesis.backendapi.db

import de.masterthesis.backendapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findById(id: UUID): Optional<User>
    fun findByMail(mail: String): User?
}