package ru.tsvlad.tsgram.user.component.client

import org.keycloak.representations.idm.UserRepresentation
import ru.tsvlad.tsgram.commons.Page

interface KeycloakClient {
    fun searchUser(searchString: String, page: Int, size: Int) : Page<UserRepresentation>
    fun getUserById(id: String) : UserRepresentation
}