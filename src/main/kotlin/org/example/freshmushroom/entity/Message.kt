package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "message", schema = "freshmushroom")
open class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Lob
    @Column(name = "content", nullable = false)
    open var content: String? = null

    @Column(name = "status")
    open var status: Byte? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null
}