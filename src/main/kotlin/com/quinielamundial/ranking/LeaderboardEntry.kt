package com.quinielamundial.ranking

interface LeaderboardEntry {
    fun getUserId(): Long
    fun getUserName(): String
    fun getTotalPoints(): Int
    fun getExactMatches(): Long
    fun getRank(): Long
}
