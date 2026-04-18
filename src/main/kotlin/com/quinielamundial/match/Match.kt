package com.quinielamundial.match

import com.quinielamundial.team.Team
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "matches")
class Match(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "home_team_id", nullable = false)
    var homeTeam: Team,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "away_team_id", nullable = false)
    var awayTeam: Team,

    @Column(name = "home_score")
    var homeScore: Int? = null,

    @Column(name = "away_score")
    var awayScore: Int? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var phase: MatchPhase,

    @Column(nullable = false)
    var venue: String,

    @Column(name = "start_time", nullable = false)
    var startTime: Instant,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: MatchStatus = MatchStatus.SCHEDULED
)
