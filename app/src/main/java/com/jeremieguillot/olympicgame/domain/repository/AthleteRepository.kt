package com.jeremieguillot.olympicgame.domain.repository

import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel

interface AthleteRepository {

    suspend fun getAthletes(): List<OlympicAthleteModel>

    suspend fun getAthleteResults(id: String): List<OlympicAthleteResultsModel>

}
