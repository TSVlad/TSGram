package ru.tsvlad.tsgram.user.component.client.impl

import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.resource.RealmResource
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.stereotype.Component
import ru.tsvlad.tsgram.commons.Page
import ru.tsvlad.tsgram.user.component.client.KeycloakClient
import ru.tsvlad.tsgram.user.config.props.KeycloakProperties

@Component
class KeycloakClientImpl (
    val keycloak: Keycloak,
    val keycloakProperties: KeycloakProperties
) : KeycloakClient {
    override fun searchUser(searchString: String, page: Int, size: Int) : Page<UserRepresentation> {
        val count = realm().users().count(searchString)
        return Page(realm().users().search(searchString, page * size, size), page, size, count / size + 1)

    }

    override fun getUserById(id: String): UserRepresentation {
        return realm().users().get(id).toRepresentation()
    }

    private fun realm() : RealmResource {
        return keycloak.realm(keycloakProperties.realm)
    }
}