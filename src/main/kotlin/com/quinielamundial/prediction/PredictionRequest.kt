package com.quinielamundial.prediction

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class PredictionRequest(
    @field:NotNull
    val matchId: Long?,

    @field:NotNull
    @field:Min(0)
    val homeScore: Int?,

    @field:NotNull
    @field:Min(0)
    val awayScore: Int?
)
