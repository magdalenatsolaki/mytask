package de.masterthesis.backendapi.db

import de.masterthesis.backendapi.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
    fun findById(id: UUID): Optional<UserEntity>
    fun findByMail(mail: String): UserEntity?
}