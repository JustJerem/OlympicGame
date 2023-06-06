package com.jeremieguillot.olympicgame.data.repository.fake


import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import kotlin.random.Random

class FakeModelRepository {
    companion object {

        fun getGames(total: Int = 10) =
            List(total) { getGame() }

        fun getOlympicAthleteModels(total: Int = 10) =
            List(total) { getOlympicAthleteModel() }

        fun getOlympicAthleteResultsModels(total: Int = 10) =
            List(total) { getOlympicAthleteResultsModel() }

        private fun getOlympicAthleteModel() = OlympicAthleteModel(
            "",
            getRandomString(),
            "",
            getRandomString(),
            getRandomString(),
            getRandomString(),
            OlympicAthleteModel.AthleteMeasurements(Random.nextInt(), Random.nextInt())
        )

        private fun getOlympicAthleteResultsModel() = OlympicAthleteResultsModel(
            getRandomString(),
            2000,
            Random.nextInt(),
            Random.nextInt(),
            Random.nextInt(),
        )

        private fun getGame() = OlympicGameModel(
            Random.nextInt(),
            getRandomString(),
            2000,
        )

        private fun getRandomString(length: Int = 10): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }
    }
}