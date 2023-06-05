package com.jeremieguillot.olympicgame.domain.repository

interface AthleteRepository {

    suspend fun getAthletes()

    suspend fun getAthlete(id: String)

    suspend fun getAthleteResults(id: String)

}
