package org.example.freshmushroom.service
import org.example.freshmushroom.dataSource.DynamicDataSourceContextHolder
import org.example.freshmushroom.entity.User
import org.example.freshmushroom.entity_repo.UserRepository
import org.example.freshmushroom.enums.DataSourceType
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronization
import org.springframework.transaction.support.TransactionSynchronizationManager

@EnableAsync
@Service
class EmailUserService(private val userRepository: UserRepository,
                       private val mailService: MailService,
                       private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun registerUser(
     user: User):User {
        user.password = passwordEncoder.encode(user.password)
        val savedUser = userRepository.save(user)
        TransactionSynchronizationManager.registerSynchronization(object : TransactionSynchronization {
            override fun afterCommit() {
                mailService.sendVerificationEmail(savedUser)
            }
        })
        return savedUser
    }
}