package com.quinielamundial.prediction

import com.quinielamundial.match.Match
import com.quinielamundial.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "predictions")
class Prediction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    var match: Match,

    @Column(name = "home_score", nullable = false)
    var homeScore: Int,

    @Column(name = "away_score", nullable = false)
    var awayScore: Int,

    @Column(name = "points")
    var points: Int? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant = Instant.now()
)
