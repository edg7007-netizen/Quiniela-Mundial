package com.quinielamundial.auth

import com.quinielamundial.user.AuthProvider
import com.quinielamundial.user.User
import com.quinielamundial.user.UserRepository
import com.quinielamundial.user.UserRole
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class OAuth2UserService(
    private val userRepository: UserRepository
) : DefaultOAuth2UserService() {
    @Throws(OAuth2AuthenticationException::class)
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val oauthUser = super.loadUser(userRequest)
        val email = oauthUser.attributes["email"] as? String ?: throw OAuth2AuthenticationException("Email requerido")
        val name = oauthUser.attributes["name"] as? String ?: email

        val user = userRepository.findByEmail(email).orElseGet {
            userRepository.save(
                User(
                    name = name,
                    email = email,
                    password = null,
                    provider = AuthProvider.GOOGLE,
                    role = UserRole.ROLE_USER,
                    createdAt = Instant.now()
                )
            )
        }

        return org.springframework.security.oauth2.core.user.DefaultOAuth2User(
            listOf(org.springframework.security.core.authority.SimpleGrantedAuthority(user.role.name)),
            oauthUser.attributes,
            "email"
        )
    }
}
