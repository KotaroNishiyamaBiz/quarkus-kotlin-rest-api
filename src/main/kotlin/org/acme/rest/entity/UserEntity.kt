package org.acme.rest.entity

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table( name = "users" )
class UserEntity : PanacheEntityBase() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int = 0

    @Column(name="first_name")
    lateinit var firstName: String

    @Column(name="last_name")
    lateinit var lastName: String

    @Column(name="created")
    lateinit var created: LocalDateTime
}
