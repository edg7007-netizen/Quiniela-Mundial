package com.quinielamundial.match

data class MatchResultRegisteredEvent(
    val matchId: Long,
    val homeScore: Int,
    val awayScore: Int
)
