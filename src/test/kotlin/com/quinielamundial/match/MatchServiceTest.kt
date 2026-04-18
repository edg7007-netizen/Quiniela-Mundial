package com.quinielamundial.match

import com.quinielamundial.team.Team
import com.quinielamundial.prediction.PredictionRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationEventPublisher
import java.time.Instant
import java.util.Optional

class MatchServiceTest {

    private val matchRepository = mockk<MatchRepository>(relaxed = true)
    private val predictionRepository = mockk<PredictionRepository>(relaxed = true)
    private val eventPublisher = mockk<ApplicationEventPublisher>(relaxed = true)
    private val service = MatchService(matchRepository, predictionRepository, eventPublisher)

    @Test
    fun `register result should set finished and publish event`() {
        val teamA = Team(id = 1L, name = "Argentina", fifaCode = "ARG", group = "A")
        val teamB = Team(id = 2L, name = "Francia", fifaCode = "FRA", group = "A")
        val match = Match(
            id = 99L,
            homeTeam = teamA,
            awayTeam = teamB,
            phase = MatchPhase.FINAL,
            venue = "NY",
            startTime = Instant.now()
        )

        every { matchRepository.findById(99L) } returns Optional.of(match)
        every { matchRepository.save(any()) } answers { firstArg() }

        val saved = service.registerResult(MatchResultRequest(99L, 2, 1))

        assertEquals(MatchStatus.FINISHED, saved.status)
        assertEquals(2, saved.homeScore)
        assertEquals(1, saved.awayScore)
        verify(exactly = 1) { eventPublisher.publishEvent(any<MatchResultRegisteredEvent>()) }
    }
}
