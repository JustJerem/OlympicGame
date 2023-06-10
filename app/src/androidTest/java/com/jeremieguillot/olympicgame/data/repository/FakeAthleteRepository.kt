package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository

class FakeAthleteRepository : AthleteRepository {
    override suspend fun getAthletes(): List<OlympicAthleteModel> {
        return listOf(
            OlympicAthleteModel(
                "1",
                "",
                "Usan",
                "Bolt",
                "Biography",
                "01/01/2000",
                OlympicAthleteModel.AthleteMeasurements(1, 1),
                getAthleteResults("1")
            )
        )
    }

    override suspend fun getAthleteResults(id: String): List<OlympicAthleteResultsModel> {
        return listOf(OlympicAthleteResultsModel("", 1992, 1, 1, 1))
    }
}