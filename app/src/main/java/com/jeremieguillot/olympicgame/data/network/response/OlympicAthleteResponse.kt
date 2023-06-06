package com.jeremieguillot.olympicgame.data.network.response


import com.jeremieguillot.olympicgame.BuildConfig
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OlympicAthleteResponse(
    @Json(name = "athlete_id")
    val athleteId: String,
    @Json(name = "bio")
    val bio: String,
    @Json(name = "dateOfBirth")
    val dateOfBirth: String,
    @Json(name = "height")
    val height: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "photo_id")
    val photoId: Int,
    @Json(name = "surname")
    val surname: String,
    @Json(name = "weight")
    val weight: Int
) {
    fun toDomainModel(): OlympicAthleteModel {
        return OlympicAthleteModel(
            athleteId = athleteId,
            photoPath = "${BuildConfig.API_BASE_URL}athletes/$photoId/photo",
            name = name,
            surname = surname,
            bio = bio,
            dateOfBirth = dateOfBirth,
            measurements = OlympicAthleteModel.AthleteMeasurements(weight, height)
        )
    }
}