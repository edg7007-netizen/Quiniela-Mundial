package com.quinielamundial.scoring

object ScoreCalculator {
    fun calculate(predHome: Int, predAway: Int, resultHome: Int, resultAway: Int): Int {
        if (predHome == resultHome && predAway == resultAway) {
            return 3
        }
        val predSign = (predHome - predAway).compareTo(0)
        val resultSign = (resultHome - resultAway).compareTo(0)
        return if (predSign == resultSign) 1 else 0
    }
}
