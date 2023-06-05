package com.jeremieguillot.olympicgame.data.network.response


import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OlympicGameResponse(
    @Json(name = "city")
    val city: String,
    @Json(name = "game_id")
    val gameId: Int,
    @Json(name = "year")
    val year: Int
) {
    internal fun toDomainModel() : OlympicGameModel {
        return OlympicGameModel(gameId, city, year)
    }
}