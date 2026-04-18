package com.quinielamundial.match

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class MatchResultRequest(
    val matchId: Long? = null,
    @field:NotNull
    @field:Min(0)
    val homeScore: Int? = null,
    @field:NotNull
    @field:Min(0)
    val awayScore: Int? = null
)
