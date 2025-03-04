package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "log", schema = "freshmushroom")
open class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "action", nullable = false, length = 100)
    open var action: String? = null

    @Lob
    @Column(name = "detail")
    open var detail: String? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null
}