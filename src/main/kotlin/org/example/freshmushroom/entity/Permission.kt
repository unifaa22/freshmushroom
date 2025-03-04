package org.example.freshmushroom.entity

import javax.persistence.*

@Entity
@Table(name = "permission", schema = "freshmushroom")
open class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null

    @Column(name = "code", nullable = false, length = 50)
    open var code: String? = null

    @Column(name = "description")
    open var description: String? = null
}