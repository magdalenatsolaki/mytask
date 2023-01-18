package de.masterthesis.backendapi.conf

import de.masterthesis.backendapi.db.TaskRepository
import de.masterthesis.backendapi.db.UserRepository
import de.masterthesis.backendapi.entity.Task
import de.masterthesis.backendapi.entity.User
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
        val smaldini = userRepository.save(User(username = "smaldini@spring.io", mail = "smaldini@spring.io"))
        val smaldini2 = userRepository.save(User(username = "smaldini2@spring.io", mail = "smaldini2@spring.io"))
        val smaldini3 = userRepository.save(User(username = "smaldini3@spring.io", mail = "smaldini3@spring.io"))
        val smaldini4 = userRepository.save(User(username = "smaldini4@spring.io", mail = "smaldini4@spring.io"))
        taskRepository.save(
            Task(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        taskRepository.save(
            Task(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
    }
}