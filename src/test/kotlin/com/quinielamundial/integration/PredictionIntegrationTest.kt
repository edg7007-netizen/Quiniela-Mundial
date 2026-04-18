package com.quinielamundial.integration

import com.quinielamundial.match.Match
import com.quinielamundial.match.MatchPhase
import com.quinielamundial.match.MatchRepository
import com.quinielamundial.prediction.PredictionRepository
import com.quinielamundial.prediction.PredictionRequest
import com.quinielamundial.prediction.PredictionService
import com.quinielamundial.team.Team
import com.quinielamundial.team.TeamRepository
import com.quinielamundial.user.AuthProvider
import com.quinielamundial.user.User
import com.quinielamundial.user.UserRepository
import com.quinielamundial.user.UserRole
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.Instant

@SpringBootTest
@ActiveProfiles("test")
class PredictionIntegrationTest {

    @Autowired
    private lateinit var predictionService: PredictionService

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Autowired
    private lateinit var predictionRepository: PredictionRepository

    @Test
    fun `should create prediction and store in db`() {
        val user = userRepository.save(
            User(name = "Ana", email = "ana@test.com", password = "x", provider = AuthProvider.LOCAL, role = UserRole.ROLE_USER)
        )
        val home = teamRepository.save(Team(name = "México", fifaCode = "MEX", group = "A"))
        val away = teamRepository.save(Team(name = "Canadá", fifaCode = "CAN", group = "A"))
        val match = matchRepository.save(
            Match(homeTeam = home, awayTeam = away, phase = MatchPhase.GROUP_STAGE, venue = "CDMX", startTime = Instant.now().plusSeconds(7200))
        )

        val prediction = predictionService.savePrediction(user, PredictionRequest(match.id, 2, 1))

        assertNotNull(prediction.id)
        assertEquals(1, predictionRepository.findAllByMatchId(match.id!!).size)
    }
}
