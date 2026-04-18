package com.quinielamundial.api.v1

import com.quinielamundial.ranking.RankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/leaderboard")
class LeaderboardRestController(
    private val rankingService: RankingService
) {
    @GetMapping
    fun list() = rankingService.getLeaderboard()
}
