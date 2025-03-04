package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "task", schema = "freshmushroom")
open class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "title", nullable = false, length = 200)
    open var title: String? = null

    @Lob
    @Column(name = "description")
    open var description: String? = null

    @Column(name = "status", length = 50)
    open var status: String? = null

    @Column(name = "priority")
    open var priority: Byte? = null

    @Column(name = "startTime")
    open var startTime: Instant? = null

    @Column(name = "endTime")
    open var endTime: Instant? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null

    @Column(name = "updateTime")
    open var updateTime: Instant? = null
}