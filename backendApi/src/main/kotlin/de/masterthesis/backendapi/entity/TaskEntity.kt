package de.masterthesis.backendapi.entity

import de.masterthesis.backendapi.toSlug
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = "tasks")
class TaskEntity(
    @Id @GeneratedValue var id: Long = 0,
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: UserEntity,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now()
)