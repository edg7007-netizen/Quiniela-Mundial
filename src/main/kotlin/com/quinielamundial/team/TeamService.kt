package com.quinielamundial.team

import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {
    fun findAll(): List<Team> = teamRepository.findAll()
    fun save(team: Team): Team = teamRepository.save(team)
}
