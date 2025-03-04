package org.example.freshmushroom.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "document", schema = "freshmushroom")
open class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 200)
    open var name: String? = null

    @Column(name = "type", length = 50)
    open var type: String? = null

    @Column(name = "filePath", nullable = false)
    open var filePath: String? = null

    @Column(name = "createTime")
    open var createTime: Instant? = null

    @Column(name = "updateTime")
    open var updateTime: Instant? = null
}