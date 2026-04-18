package com.quinielamundial.ranking

import com.quinielamundial.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RankingRepository : JpaRepository<User, Long> {
    @Query(
        value = """
            SELECT
                u.id AS userId,
                u.name AS userName,
                COALESCE(SUM(p.points), 0) AS totalPoints,
                SUM(CASE WHEN p.points = 3 THEN 1 ELSE 0 END) AS exactMatches,
                DENSE_RANK() OVER (
                    ORDER BY COALESCE(SUM(p.points), 0) DESC,
                             SUM(CASE WHEN p.points = 3 THEN 1 ELSE 0 END) DESC,
                             MIN(p.created_at) ASC NULLS LAST
                ) AS rank
            FROM users u
            LEFT JOIN predictions p ON p.user_id = u.id
            GROUP BY u.id, u.name
            ORDER BY rank ASC, userName ASC
        """,
        nativeQuery = true
    )
    fun findLeaderboard(): List<LeaderboardEntry>
}
