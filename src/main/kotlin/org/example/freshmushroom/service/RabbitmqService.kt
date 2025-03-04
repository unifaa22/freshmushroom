package org.example.freshmushroom.service

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
class RabbitmqService (private val rabbitTemplate: RabbitTemplate) {

    fun sendMessage(queueName: String, message: String) {
        rabbitTemplate.convertAndSend(queueName, message)
        println("Sent message: $message")
    }

    @RabbitListener(queues = ["my_queue"])
    fun receiveMessage(message: String) {
        println("Received message: $message")
    }
    @Bean
    fun myQueue(): Queue {
        return Queue("my_queue", false)
    }

}