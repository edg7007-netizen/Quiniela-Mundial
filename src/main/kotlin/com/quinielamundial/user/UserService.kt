package com.quinielamundial.user

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun registerLocalUser(name: String, email: String, rawPassword: String): User {
        require(!userRepository.existsByEmail(email)) { "El correo ya está registrado" }
        val user = User(
            name = name,
            email = email,
            password = passwordEncoder.encode(rawPassword),
            provider = AuthProvider.LOCAL,
            role = UserRole.ROLE_USER,
            createdAt = Instant.now()
        )
        return userRepository.save(user)
    }

    fun findByEmail(email: String): User? = userRepository.findByEmail(email).orElse(null)
}
