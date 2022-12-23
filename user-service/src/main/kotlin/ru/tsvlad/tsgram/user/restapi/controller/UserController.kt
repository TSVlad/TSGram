package ru.tsvlad.tsgram.user.restapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.tsvlad.tsgram.commons.Page
import ru.tsvlad.tsgram.user.common.User
import ru.tsvlad.tsgram.user.component.service.UserService

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
) {
    @GetMapping
    fun searchUsers(
        @RequestParam searchString: String,
        @RequestParam(required = false) page: Int = 0,
        @RequestParam(required = false) size: Int = 10
    ): ResponseEntity<Page<User>> {
        return ResponseEntity.ok(userService.searchUser(searchString, page, size))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String) : ResponseEntity<User> {
        return ResponseEntity.ok(userService.getUserById(id))
    }

    @GetMapping("/by-ids")
    fun getUsersByIds(@RequestParam(name = "id") ids: List<String>) : ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.getUsersByIds(ids))
    }
}