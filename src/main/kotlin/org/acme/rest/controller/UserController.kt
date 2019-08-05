package org.acme.rest.controller

import org.acme.rest.model.User
import org.acme.rest.request.CreateUserRequest
import org.acme.rest.request.UpdateUserRequest
import org.acme.rest.service.UserService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserController {

    @Inject
    private lateinit var userService: UserService

    @GET
    fun list(): List<User> {
        return userService.list()
    }

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id: Int): User{
        return userService.findById(id)
    }

    @POST
    fun create(request: CreateUserRequest): User {
        return userService.create(request.toUser())
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: Int, request: UpdateUserRequest): User{
        return userService.update(request.toUser(userService.findById(id)))
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Int): String {
        userService.delete(id)
        return "OK"
    }
}