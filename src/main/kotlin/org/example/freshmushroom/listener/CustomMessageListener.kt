package org.example.freshmushroom.listener



import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
class CustomMessageListener: MessageListener {

    override fun onMessage(message: Message) {
        val body = String(message.body)
        println("Custom handler received message: $body")

    }
}