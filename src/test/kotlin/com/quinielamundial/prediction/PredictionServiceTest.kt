package com.quinielamundial.prediction

import com.quinielamundial.match.Match
import com.quinielamundial.match.MatchPhase
import com.quinielamundial.match.MatchRepository
import com.quinielamundial.team.Team
import com.quinielamundial.user.AuthProvider
import com.quinielamundial.user.User
import com.quinielamundial.user.UserRole
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.Optional

class PredictionServiceTest {

    private val predictionRepository = mockk<PredictionRepository>(relaxed = true)
    private val matchRepository = mockk<MatchRepository>()
    private val service = PredictionService(predictionRepository, matchRepository)

    private val user = User(
        id = 10L,
        name = "User",
        email = "user@test.com",
        password = "x",
        provider = AuthProvider.LOCAL,
        role = UserRole.ROLE_USER,
        createdAt = Instant.now()
    )

    private val teamA = Team(id = 1L, name = "México", fifaCode = "MEX", group = "A")
    private val teamB = Team(id = 2L, name = "Brasil", fifaCode = "BRA", group = "A")

    @Test
    fun `should save prediction successfully`() {
        val match = Match(
            id = 20L,
            homeTeam = teamA,
            awayTeam = teamB,
            phase = MatchPhase.GROUP_STAGE,
            venue = "CDMX",
            startTime = Instant.now().plusSeconds(7200)
        )
        every { predictionRepository.existsByUserIdAndMatchId(10L, 20L) } returns false
        every { matchRepository.findById(20L) } returns Optional.of(match)
        every { predictionRepository.save(any()) } answers { firstArg() }

        service.savePrediction(user, PredictionRequest(matchId = 20L, homeScore = 2, awayScore = 1))

        verify(exactly = 1) { predictionRepository.save(any()) }
    }

    @Test
    fun `should throw when prediction window is closed`() {
        val match = Match(
            id = 20L,
            homeTeam = teamA,
            awayTeam = teamB,
            phase = MatchPhase.GROUP_STAGE,
            venue = "CDMX",
            startTime = Instant.now().plusSeconds(900)
        )
        every { predictionRepository.existsByUserIdAndMatchId(10L, 20L) } returns false
        every { matchRepository.findById(20L) } returns Optional.of(match)

        assertThrows(PredictionClosedException::class.java) {
            service.savePrediction(user, PredictionRequest(matchId = 20L, homeScore = 1, awayScore = 0))
        }
    }

    @Test
    fun `should throw when duplicate prediction exists`() {
        every { predictionRepository.existsByUserIdAndMatchId(10L, 20L) } returns true

        assertThrows(DuplicatePredictionException::class.java) {
            service.savePrediction(user, PredictionRequest(matchId = 20L, homeScore = 1, awayScore = 0))
        }
    }
}
