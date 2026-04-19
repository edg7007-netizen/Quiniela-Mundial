package com.quinielamundial.web

import com.quinielamundial.match.MatchService
import com.quinielamundial.ranking.RankingService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    private val matchService: MatchService,
    private val rankingService: RankingService
) {
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("upcomingMatches", matchService.findAllUpcoming().take(4))
        model.addAttribute("topEntries", rankingService.getLeaderboard().take(5))
        return "home"
    }
}
