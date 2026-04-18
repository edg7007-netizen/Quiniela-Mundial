package com.quinielamundial.prediction

import com.quinielamundial.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface PredictionRepository : JpaRepository<Prediction, Long> {
    fun existsByUserIdAndMatchId(userId: Long, matchId: Long): Boolean
    fun findAllByMatchId(matchId: Long): List<Prediction>
    fun findAllByUserOrderByCreatedAtDesc(user: User): List<Prediction>
}
