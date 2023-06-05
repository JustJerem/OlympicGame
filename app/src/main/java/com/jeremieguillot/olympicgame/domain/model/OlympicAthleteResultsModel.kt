package com.jeremieguillot.olympicgame.domain.model

data class OlympicAthleteResultsModel(
    val city: String,
    val year: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
)
