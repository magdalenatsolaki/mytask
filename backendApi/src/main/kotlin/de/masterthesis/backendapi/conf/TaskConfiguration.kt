package de.masterthesis.backendapi.conf

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.db.UserRepository
import de.masterthesis.backendapi.entity.TaskEntity
import de.masterthesis.backendapi.entity.UserEntity
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskConfiguration {
    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        taskRepository: TaskRepository
    ) = ApplicationRunner {
        val smaldini = userRepository.save(UserEntity(username = "smaldini@spring.io", mail = "smaldini@spring.io"))
        userRepository.save(UserEntity(username = "smaldini2@spring.io", mail = "smaldini2@spring.io"))
        userRepository.save(UserEntity(username = "smaldini3@spring.io", mail = "smaldini3@spring.io"))
        userRepository.save(UserEntity(username = "smaldini4@spring.io", mail = "smaldini4@spring.io"))
        taskRepository.save(
            TaskEntity(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        taskRepository.save(
            TaskEntity(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
    }
}