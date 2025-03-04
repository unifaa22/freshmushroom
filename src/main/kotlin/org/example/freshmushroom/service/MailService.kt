package org.example.freshmushroom.service

import org.example.freshmushroom.entity.User
import org.springframework.mail.MailSender
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Service

@EnableAsync
@Service
class MailService(private val mailSender: JavaMailSender ){
    @Async
    fun sendVerificationEmail(user: User) {
        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)
        user.email?.let { helper.setTo(it) }
        helper.setSubject("Verification Email")
        helper.setText("Please verify your email address.", true)
        mailSender.send(message)
    }
}