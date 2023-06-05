package com.jeremieguillot.olympicgame.domain.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface GameRepository {

    suspend fun getGames()

    suspend fun getAthletesInGame(id: String)
}
