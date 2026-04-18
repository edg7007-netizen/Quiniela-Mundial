package com.quinielamundial.team

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "teams")
class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(name = "fifa_code", length = 3, nullable = false, unique = true)
    var fifaCode: String,

    @Column(name = "group_name", length = 2, nullable = false)
    var group: String,

    @Column(name = "flag_url")
    var flagUrl: String? = null
)
