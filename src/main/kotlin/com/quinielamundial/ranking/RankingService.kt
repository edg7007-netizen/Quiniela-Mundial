package com.quinielamundial.ranking

import org.springframework.stereotype.Service

@Service
class RankingService(
    private val rankingRepository: RankingRepository
) {
    fun getLeaderboard(): List<LeaderboardEntry> = rankingRepository.findLeaderboard()
}
