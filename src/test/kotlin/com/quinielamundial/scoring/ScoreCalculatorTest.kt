package com.quinielamundial.scoring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreCalculatorTest {

    @Test
    fun `should return 3 for exact match`() {
        assertEquals(3, ScoreCalculator.calculate(2, 1, 2, 1))
    }

    @Test
    fun `should return 1 for correct tendency home win`() {
        assertEquals(1, ScoreCalculator.calculate(3, 1, 2, 0))
    }

    @Test
    fun `should return 1 for correct tendency away win`() {
        assertEquals(1, ScoreCalculator.calculate(0, 2, 1, 3))
    }

    @Test
    fun `should return 1 for correct tendency draw`() {
        assertEquals(1, ScoreCalculator.calculate(0, 0, 2, 2))
    }

    @Test
    fun `should return 0 for wrong prediction`() {
        assertEquals(0, ScoreCalculator.calculate(2, 1, 1, 2))
    }

    @Test
    fun `should return 3 for exact zero zero`() {
        assertEquals(3, ScoreCalculator.calculate(0, 0, 0, 0))
    }

    @Test
    fun `should support high scores`() {
        assertEquals(3, ScoreCalculator.calculate(7, 6, 7, 6))
    }
}
