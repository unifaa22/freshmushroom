package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "organization", schema = "freshmushroom")
open class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null

    @Column(name = "parentId")
    open var parentId: Long? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null

    @Column(name = "updateTime")
    open var updateTime: Instant? = null
}