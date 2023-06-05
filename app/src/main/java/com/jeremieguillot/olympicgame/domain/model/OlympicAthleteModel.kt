package com.jeremieguillot.olympicgame.domain.model

data class OlympicAthleteModel(
    val athleteId: String,
    val photoId: Int,
    val name: String,
    val surname: String,
    val bio: String,
    val dateOfBirth: String,
    val measurements: AthleteMeasurements
) {
    data class AthleteMeasurements(val weight: Int, val height: Int)
}
