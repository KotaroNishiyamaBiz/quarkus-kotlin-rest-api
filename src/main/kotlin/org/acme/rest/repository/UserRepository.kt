package org.acme.rest.repository

import org.acme.rest.model.User

interface UserRepository {

    fun list(): List<User>

    fun create(user: User): User

    fun findById(id: Int): User

    fun update(user: User): User

    fun delete(id: Int)
}