package org.example.freshmushroom.entity

import javax.persistence.*

@Entity
@Table(name = "rolepermission", schema = "freshmushroom")
open class Rolepermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleId", nullable = false)
    open var role: Role? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permissionId", nullable = false)
    open var permission: Permission? = null
}