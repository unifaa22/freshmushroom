package org.example.freshmushroom.service

import org.example.freshmushroom.annotation.SlaveDataSource
import org.example.freshmushroom.dataSource.DynamicDataSourceContextHolder
import org.example.freshmushroom.entity.User
import org.example.freshmushroom.entity_repo.UserRepository
import org.example.freshmushroom.enums.DataSourceType
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun createUser(user: User): User {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.MASTER)
        try {
            val savedUser = userRepository.save(user)
            if (savedUser.id == null) {
                throw IllegalStateException("User ID should not be null after saving")
            }
            return savedUser
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceType()
        }
    }

    @SlaveDataSource
    @Cacheable(value = ["userCache"], key = "#id")
    @Transactional(readOnly = true)
    fun getUserById(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            UserNotFoundException("User not found with id: $id")
        }
    }
    class UserNotFoundException(message: String) : Exception(message)
}