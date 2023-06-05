package com.jeremieguillot.olympicgame.data.network.client

import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResultsResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicGameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OlympicApiClient {

    @GET("athletes")
    suspend fun getAthletes() : Response<List<OlympicAthleteResponse>>

    @GET("athletes/{athlete_id}")
    suspend fun getAthlete(
        @Path("athlete_id") id: String,
    ) : Response<OlympicAthleteResponse>

    @GET("athletes/{athlete_id}/results")
    suspend fun getAthleteResults(
        @Path("athlete_id") id: String,
    ) : Response<List<OlympicAthleteResultsResponse>>

    @GET("games")
    suspend fun getGames() : Response<List<OlympicGameResponse>>

    @GET("/games/{game_id}/athletes")
    suspend fun getAthletesInGame(
        @Path("game_id") gameId: String,
    ) : Response<List<OlympicGameResponse>>
}