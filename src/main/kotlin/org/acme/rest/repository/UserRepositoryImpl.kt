package org.acme.rest.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import org.acme.rest.entity.UserEntity
import org.acme.rest.model.User
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.LockModeType

@ApplicationScoped
class UserRepositoryImpl : UserRepository, PanacheRepository<UserEntity> {

    @Inject
    lateinit var entityManager: EntityManager

    override fun update(user: User): User {
        val previous = find("id", user.id).firstResult<UserEntity>() ?: run {
            throw Exception("not found")
        }
        entityManager.lock(previous, LockModeType.WRITE)
        previous.firstName = user.firstName
        previous.lastName = user.lastName
        return user
    }

    override fun findById(id: Int): User {
        val entity = find("id", id).firstResult<UserEntity>() ?: run {
            throw Exception("not found")
        }
        return User.fromEntity(entity)
    }

    override fun delete(id: Int) {
        val entity = find("id", id).firstResult<UserEntity>() ?: run {
            throw Exception("not found")
        }
        entity.delete()
    }

    override fun list(): List<User> {
        return listAll().map { entity -> User.fromEntity(entity) }
    }

    override fun create(user: User): User {
        user.toEntity().persist()
        return user
    }

}