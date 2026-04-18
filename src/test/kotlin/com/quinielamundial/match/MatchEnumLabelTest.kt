package com.quinielamundial.match

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatchEnumLabelTest {
    @Test
    fun `should expose spanish labels for match phases`() {
        assertEquals("Fase de Grupos", MatchPhase.GROUP_STAGE.label)
        assertEquals("Octavos de Final", MatchPhase.ROUND_OF_16.label)
        assertEquals("Final", MatchPhase.FINAL.label)
    }

    @Test
    fun `should expose spanish labels for match status`() {
        assertEquals("Programado", MatchStatus.SCHEDULED.label)
        assertEquals("En vivo", MatchStatus.LIVE.label)
        assertEquals("Finalizado", MatchStatus.FINISHED.label)
    }
}
