package com.quinielamundial.prediction

import com.quinielamundial.match.MatchRepository
import com.quinielamundial.user.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.time.Instant

@Service
class PredictionService(
    private val predictionRepository: PredictionRepository,
    private val matchRepository: MatchRepository
) {
    @Transactional
    fun savePrediction(user: User, request: PredictionRequest): Prediction {
        val matchId = request.matchId ?: throw IllegalArgumentException("Partido inválido")
        if (predictionRepository.existsByUserIdAndMatchId(user.id!!, matchId)) {
            throw DuplicatePredictionException("Ya registraste un pronóstico para este partido")
        }

        val match = matchRepository.findById(matchId).orElseThrow { IllegalArgumentException("Partido no encontrado") }
        val now = Instant.now()
        if (Duration.between(now, match.startTime).toMinutes() < 30) {
            throw PredictionClosedException("El pronóstico está cerrado para este partido")
        }

        val prediction = Prediction(
            user = user,
            match = match,
            homeScore = request.homeScore!!,
            awayScore = request.awayScore!!,
            points = null,
            createdAt = now
        )
        return predictionRepository.save(prediction)
    }

    fun findByMatchId(matchId: Long): List<Prediction> = predictionRepository.findAllByMatchId(matchId)

    fun findHistory(user: User): List<Prediction> = predictionRepository.findAllByUserOrderByCreatedAtDesc(user)
}
