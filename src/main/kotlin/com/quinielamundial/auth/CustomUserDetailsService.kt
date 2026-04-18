package com.quinielamundial.auth

import com.quinielamundial.user.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    private val log = LoggerFactory.getLogger(CustomUserDetailsService::class.java)

    override fun loadUserByUsername(username: String): UserDetails {
        log.debug("Attempting to load user by email: {}", username)
        val user = userRepository.findByEmail(username)
            .orElseThrow {
                log.warn("Authentication failed: no user found with email '{}'", username)
                UsernameNotFoundException("Usuario no encontrado: $username")
            }
        log.debug("User loaded successfully: email={}, role={}, provider={}", user.email, user.role, user.provider)
        return CustomUserDetails(user)
    }
}
