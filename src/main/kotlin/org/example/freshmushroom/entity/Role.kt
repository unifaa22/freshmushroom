package org.example.freshmushroom.entity

import javax.persistence.*

@Entity
@Table(name = "role", schema = "freshmushroom")
open class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null

    @Column(name = "description")
    open var description: String? = null
}