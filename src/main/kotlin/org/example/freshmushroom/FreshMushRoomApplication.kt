package org.example.freshmushroom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching


@SpringBootApplication

@EnableCaching

class FreshMushRoomApplication

fun main(args: Array<String>) {
    runApplication<FreshMushRoomApplication>(*args)

}
