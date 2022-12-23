package ru.tsvlad.tsgram.user.component.mapper

import org.keycloak.representations.idm.UserRepresentation
import org.mapstruct.Mapper
import org.springframework.stereotype.Component
import ru.tsvlad.tsgram.user.common.User

/*@Mapper(componentModel = "spring")*/
@Component
/*abstract*/ class UserMapper {

    fun representationToUser(userRepresentation: UserRepresentation) : User {
        return User(userRepresentation.id,
            userRepresentation.firstName,
            userRepresentation.lastName,
            userRepresentation.username)
    }
}