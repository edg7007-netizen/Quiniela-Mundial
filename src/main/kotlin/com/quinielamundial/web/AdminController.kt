package com.quinielamundial.web

import com.quinielamundial.match.MatchResultRequest
import com.quinielamundial.match.MatchService
import com.quinielamundial.team.TeamService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AdminController(
    private val matchService: MatchService,
    private val teamService: TeamService
) {
    @GetMapping("/admin/matches")
    fun matches(model: Model): String {
        model.addAttribute("matches", matchService.findAllUpcoming())
        model.addAttribute("resultRequest", MatchResultRequest(null, 0, 0))
        return "admin/matches"
    }

    @PostMapping("/admin/matches/{id}/result")
    fun registerResult(@PathVariable id: Long, @Valid request: MatchResultRequest): String {
        matchService.registerResult(request.copy(matchId = id))
        return "redirect:/admin/matches"
    }

    @GetMapping("/admin/teams")
    fun teams(model: Model): String {
        model.addAttribute("teams", teamService.findAll())
        return "admin/teams"
    }

    @GetMapping("/admin/users")
    fun users(): String = "admin/users"
}
