package org.acme.rest.service

import org.acme.rest.model.User

interface UserService {

    fun list(): List<User>

    fun findById(id: Int): User

    fun create(user: User): User

    fun update(user: User): User

    fun delete(id: Int)
}