package org.example.freshmushroom.config
import org.example.freshmushroom.listener.CustomMessageListener
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
class RabbitMQConfig {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(7)
    }
    @Bean
    fun customListenerContainer(connectionFactory: ConnectionFactory): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames("my_queue")
        container.setMessageListener(CustomMessageListener())
        return container
    }

}