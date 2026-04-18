package com.quinielamundial.web

import com.quinielamundial.ranking.RankingService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LeaderboardController(
    private val rankingService: RankingService
) {
    @GetMapping("/leaderboard")
    fun index(model: Model): String {
        model.addAttribute("entries", rankingService.getLeaderboard())
        return "leaderboard/index"
    }
}
