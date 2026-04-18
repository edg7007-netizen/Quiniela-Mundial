package com.quinielamundial.web

import com.quinielamundial.match.MatchService
import com.quinielamundial.prediction.PredictionRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MatchController(
    private val matchService: MatchService
) {
    @GetMapping("/matches")
    fun list(model: Model): String {
        model.addAttribute("matches", matchService.findAllUpcoming())
        return "match/list"
    }

    @GetMapping("/matches/{id}")
    fun detail(@PathVariable id: Long, model: Model): String {
        model.addAttribute("match", matchService.findById(id))
        model.addAttribute("predictionRequest", PredictionRequest(matchId = id, homeScore = 0, awayScore = 0))
        return "match/detail"
    }
}
