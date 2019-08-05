package org.acme.rest.request

import org.acme.rest.model.User

class UpdateUserRequest{
    lateinit var firstName: String
    lateinit var lastName: String

    fun toUser(user: User) = User(id = user.id, firstName = this.firstName, lastName = this.lastName, created = user.created)
}
