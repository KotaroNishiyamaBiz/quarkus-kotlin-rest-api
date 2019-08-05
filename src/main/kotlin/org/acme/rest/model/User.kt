package org.acme.rest.model

import org.acme.rest.entity.UserEntity
import java.time.LocalDateTime

data class User(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val created: LocalDateTime
) {
    companion object {
        fun fromEntity(entity: UserEntity): User {
            return User(id = entity.id, firstName = entity.firstName, lastName = entity.lastName, created = entity.created)
        }
    }

    fun toEntity(): UserEntity {
        val entity  =UserEntity()
        entity.id = this.id
        entity.firstName = this.firstName
        entity.lastName = this.lastName
        entity.created = this.created
        return entity
    }
}
