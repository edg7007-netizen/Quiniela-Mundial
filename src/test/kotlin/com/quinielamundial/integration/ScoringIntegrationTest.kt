package com.quinielamundial.integration

import com.quinielamundial.match.Match
import com.quinielamundial.match.MatchPhase
import com.quinielamundial.match.MatchRepository
import com.quinielamundial.match.MatchResultRequest
import com.quinielamundial.match.MatchService
import com.quinielamundial.prediction.PredictionRequest
import com.quinielamundial.prediction.PredictionService
import com.quinielamundial.team.Team
import com.quinielamundial.team.TeamRepository
import com.quinielamundial.user.AuthProvider
import com.quinielamundial.user.User
import com.quinielamundial.user.UserRepository
import com.quinielamundial.user.UserRole
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.support.TransactionTemplate
import java.time.Instant

@SpringBootTest
@ActiveProfiles("test")
class ScoringIntegrationTest {

    @Autowired
    private lateinit var predictionService: PredictionService

    @Autowired
    private lateinit var matchService: MatchService

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Autowired
    private lateinit var transactionTemplate: TransactionTemplate

    @Test
    fun `should score predictions after result registration`() {
        val user = userRepository.save(
            User(name = "Luis", email = "luis@test.com", password = "x", provider = AuthProvider.LOCAL, role = UserRole.ROLE_USER)
        )
        val home = teamRepository.save(Team(name = "España", fifaCode = "ESP", group = "B"))
        val away = teamRepository.save(Team(name = "Japón", fifaCode = "JPN", group = "B"))
        val match = matchRepository.save(
            Match(homeTeam = home, awayTeam = away, phase = MatchPhase.GROUP_STAGE, venue = "LA", startTime = Instant.now().plusSeconds(7200))
        )

        predictionService.savePrediction(user, PredictionRequest(match.id, 1, 0))

        transactionTemplate.executeWithoutResult {
            matchService.registerResult(MatchResultRequest(match.id, 1, 0))
        }

        var savedPrediction = predictionService.findByMatchId(match.id!!).first()
        repeat(10) {
            if (savedPrediction.points != null) return@repeat
            Thread.sleep(100)
            savedPrediction = predictionService.findByMatchId(match.id!!).first()
        }
        assertEquals(3, savedPrediction.points)
    }
}
