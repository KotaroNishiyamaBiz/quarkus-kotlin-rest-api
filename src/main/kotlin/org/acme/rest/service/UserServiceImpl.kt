package org.acme.rest.service

import org.acme.rest.model.User
import org.acme.rest.repository.UserRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class UserServiceImpl : UserService {

    @Inject
    private lateinit var userRepository: UserRepository

    override fun list(): List<User> {
        return userRepository.list()
    }

    @Transactional
    override fun create(user: User): User {
        userRepository.create(user)
        return user
    }

    override fun delete(id: Int) {
        userRepository.delete(id)
    }

    @Transactional
    override fun update(user: User): User {
        userRepository.update(user)
        return user
    }

    override fun findById(id: Int): User {
        return userRepository.findById(id)
    }
}