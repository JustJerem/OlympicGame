package com.jeremieguillot.olympicgame.domain.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OlympicAthleteModel(
    val athleteId: String,
    val photoPath: String,
    val name: String,
    val surname: String,
    val bio: String,
    val dateOfBirth: String,
    val measurements: AthleteMeasurements,
    var results: List<OlympicAthleteResultsModel> = emptyList()
) : Parcelable {


    @Parcelize
    data class AthleteMeasurements(val weight: Int, val height: Int) : Parcelable
}
