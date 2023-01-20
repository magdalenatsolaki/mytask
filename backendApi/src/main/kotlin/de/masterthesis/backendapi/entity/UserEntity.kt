package de.masterthesis.backendapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.*

@Entity(name = "users")
class UserEntity(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    @Column(unique = true)
    var username: String,
    @Column(unique = true)
    var mail: String,
    val addedAt: LocalDateTime = LocalDateTime.now(),
)