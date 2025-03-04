package org.example.freshmushroom.entity

import javax.persistence.*

@Entity
@Table(name = "userorganization", schema = "freshmushroom")
open class Userorganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    open var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizationId", nullable = false)
    open var organization: Organization? = null

    @Column(name = "role", length = 50)
    open var role: String? = null
}