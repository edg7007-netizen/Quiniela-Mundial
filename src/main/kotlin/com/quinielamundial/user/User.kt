package com.quinielamundial.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column
    var password: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var provider: AuthProvider = AuthProvider.LOCAL,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: UserRole = UserRole.ROLE_USER,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant = Instant.now()
)
