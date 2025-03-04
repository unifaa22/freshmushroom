package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "user", schema = "freshmushroom")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "username", nullable = false, length = 50)
    open var username: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @Column(name = "email", length = 100)
    open var email: String? = null

    @Column(name = "phone", length = 20)
    open var phone: String? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null

    @Column(name = "updateTime")
    open var updateTime: Instant? = null

    @Column(name = "status")
    open var status: Byte? = null

    constructor()
    constructor(username: String, password: String, email: String) {
        username.also { this.username = it }
        password.also { this.password = it }
        email.also { this.email = it }
    }
}