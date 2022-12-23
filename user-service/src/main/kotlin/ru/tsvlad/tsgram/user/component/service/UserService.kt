package ru.tsvlad.tsgram.user.component.service

import ru.tsvlad.tsgram.commons.Page
import ru.tsvlad.tsgram.user.common.User

interface UserService {
    fun searchUser(searchString: String, page: Int, size: Int) : Page<User>
    fun getUserById(id: String) : User
    fun getUsersByIds(ids: List<String>) : List<User>
}