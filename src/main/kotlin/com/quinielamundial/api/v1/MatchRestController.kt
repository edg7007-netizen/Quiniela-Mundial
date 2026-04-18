package com.quinielamundial.api.v1

import com.quinielamundial.match.MatchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/matches")
class MatchRestController(
    private val matchService: MatchService
) {
    @GetMapping
    fun list() = matchService.findAllUpcoming()

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long) = matchService.findById(id)
}
