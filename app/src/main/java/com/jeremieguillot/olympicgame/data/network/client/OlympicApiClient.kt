package com.jeremieguillot.olympicgame.data.network.client

import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResultsResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicGameResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OlympicApiClient {

    @GET("athletes")
    suspend fun getAthletes(): List<OlympicAthleteResponse>

    @GET("athletes/{athlete_id}/results")
    suspend fun getAthleteResults(
        @Path("athlete_id") id: String,
    ): List<OlympicAthleteResultsResponse>

    @GET("games")
    suspend fun getGames(): List<OlympicGameResponse>
}