package ru.tsvlad.tsgram.user.component.service.impl

import org.keycloak.representations.idm.UserRepresentation
import org.springframework.stereotype.Service
import ru.tsvlad.tsgram.commons.Page
import ru.tsvlad.tsgram.commons.exceptions.NotFoundException
import ru.tsvlad.tsgram.user.common.User
import ru.tsvlad.tsgram.user.component.client.KeycloakClient
import ru.tsvlad.tsgram.user.component.mapper.UserMapper
import ru.tsvlad.tsgram.user.component.service.UserService

@Service
class UserServiceImpl(
    val keycloakClient: KeycloakClient,
    val userMapper: UserMapper
) : UserService {
    override fun searchUser(searchString: String, page: Int, size: Int): Page<User> {
        return  keycloakClient.searchUser(searchString, page, size).map(userMapper::representationToUser)
    }

    override fun getUserById(id: String): User {
        val userRepresentation : UserRepresentation
        try {
            userRepresentation = keycloakClient.getUserById(id)
        } catch (notFoundException : javax.ws.rs.NotFoundException) {
            throw NotFoundException("User with id $id not found")
        }

        return userMapper.representationToUser(userRepresentation)
    }

    override fun getUsersByIds(ids: List<String>): List<User> {
        val res = ArrayList<User>()
        for (id in ids) {
            res.add(getUserById(id))
        }
        return res
    }
}