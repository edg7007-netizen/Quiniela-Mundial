package com.quinielamundial.match

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class MatchService(
    private val matchRepository: MatchRepository,
    private val eventPublisher: ApplicationEventPublisher
) {
    fun findAllUpcoming(): List<Match> = matchRepository.findAllByStartTimeAfterOrderByStartTimeAsc(Instant.now())

    fun findById(id: Long): Match = matchRepository.findById(id).orElseThrow { IllegalArgumentException("Partido no encontrado") }

    @Transactional
    fun registerResult(request: MatchResultRequest): Match {
        val match = findById(request.matchId!!)
        match.homeScore = request.homeScore
        match.awayScore = request.awayScore
        match.status = MatchStatus.FINISHED
        val saved = matchRepository.save(match)
        eventPublisher.publishEvent(
            MatchResultRegisteredEvent(saved.id!!, saved.homeScore!!, saved.awayScore!!)
        )
        return saved
    }
}
