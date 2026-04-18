package com.quinielamundial.config

import com.quinielamundial.auth.CustomUserDetailsService
import com.quinielamundial.auth.OAuth2UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService,
    private val oAuth2UserService: OAuth2UserService
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationProvider(passwordEncoder: PasswordEncoder): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider(customUserDetailsService)
        provider.setPasswordEncoder(passwordEncoder)
        return provider
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.requestMatchers("/", "/login", "/register", "/css/**", "/error/**").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/api/v1/**").authenticated()
                    .anyRequest().authenticated()
            }
            .formLogin {
                it.loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            }
            .oauth2Login {
                it.loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .userInfoEndpoint { endpoint -> endpoint.userService(oAuth2UserService) }
            }
            .logout {
                it.logoutSuccessUrl("/login?logout")
                    .permitAll()
            }
            .csrf {
                it.ignoringRequestMatchers("/api/v1/**")
            }
            .exceptionHandling {
                it.accessDeniedPage("/error/403")
            }
            .authenticationProvider(authenticationProvider(passwordEncoder()))
            .httpBasic { it.disable() }

        return http.build()
    }
}
