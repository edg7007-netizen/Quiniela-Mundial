package com.quinielamundial.match

import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant

interface MatchRepository : JpaRepository<Match, Long> {
    fun findAllByStartTimeAfterOrderByStartTimeAsc(now: Instant): List<Match>
}
