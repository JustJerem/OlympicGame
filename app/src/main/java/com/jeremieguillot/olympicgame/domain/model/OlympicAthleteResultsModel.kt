package com.jeremieguillot.olympicgame.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OlympicAthleteResultsModel(
    val city: String,
    val year: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
) : Parcelable {

    val score: Int
        get() = gold * 5 + silver * 3 + bronze
}
