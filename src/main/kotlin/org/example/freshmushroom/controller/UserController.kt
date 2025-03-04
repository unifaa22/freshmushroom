package org.example.freshmushroom.controller

import org.example.freshmushroom.entity.User
import org.example.freshmushroom.entity_repo.UserRepository
import org.example.freshmushroom.service.EmailUserService
import org.example.freshmushroom.service.UserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val emailUserService: EmailUserService,
    private val userRepository: UserRepository
) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.createUser(user)
        return ResponseEntity.ok(createdUser)
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        return try {
            val user = userService.getUserById(id)
            ResponseEntity.ok(user)
        } catch (e: UserService.UserNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/register", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val alUser = emailUserService.registerUser(user)
        return ResponseEntity.ok(alUser)
    }
}