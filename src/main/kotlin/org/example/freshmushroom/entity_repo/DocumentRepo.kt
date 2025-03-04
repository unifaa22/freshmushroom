package org.example.freshmushroom.entity_repo

import org.example.freshmushroom.entity.Document
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository

interface DocumentRepo: JpaRepository<Document,Long> {


}