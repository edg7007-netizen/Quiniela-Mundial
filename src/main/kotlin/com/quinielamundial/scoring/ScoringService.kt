package com.quinielamundial.scoring

import com.quinielamundial.match.MatchResultRegisteredEvent
import com.quinielamundial.prediction.PredictionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Service
class ScoringService(
    private val predictionRepository: PredictionRepository
) {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun onMatchResultRegistered(event: MatchResultRegisteredEvent) {
        val predictions = predictionRepository.findAllByMatchId(event.matchId)
        predictions.forEach { prediction ->
            prediction.points = ScoreCalculator.calculate(
                prediction.homeScore,
                prediction.awayScore,
                event.homeScore,
                event.awayScore
            )
        }
        predictionRepository.saveAll(predictions)
    }
}
