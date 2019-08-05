package org.acme.rest.request

import org.acme.rest.model.User
import java.time.LocalDateTime

class CreateUserRequest{
        lateinit var firstName: String
        lateinit var lastName: String

        fun toUser() = User(id = 0, firstName = this.firstName, lastName = this.lastName, created = LocalDateTime.now())
}
