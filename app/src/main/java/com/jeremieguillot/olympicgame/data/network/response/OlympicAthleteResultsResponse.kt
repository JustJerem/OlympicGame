package com.jeremieguillot.olympicgame.data.network.response


import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OlympicAthleteResultsResponse(
    @Json(name = "bronze")
    val bronze: Int,
    @Json(name = "city")
    val city: String,
    @Json(name = "gold")
    val gold: Int,
    @Json(name = "silver")
    val silver: Int,
    @Json(name = "year")
    val year: Int
){
    internal fun toDomainModel() : OlympicAthleteResultsModel{
        return OlympicAthleteResultsModel(city, year, gold, silver, bronze)
    }
}