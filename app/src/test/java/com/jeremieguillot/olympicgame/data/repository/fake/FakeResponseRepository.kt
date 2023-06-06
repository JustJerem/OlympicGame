package com.jeremieguillot.olympicgame.data.repository.fake

import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicAthleteResultsResponse
import com.jeremieguillot.olympicgame.data.network.response.OlympicGameResponse
import kotlin.random.Random

class FakeResponseRepository {
    companion object {

        fun getGames(total: Int = 10) =
            List(total) { getGame() }

        fun getOlympicAthleteResponses(total: Int = 10) =
            List(total) { getOlympicAthleteResponse() }

        fun getOlympicAthleteResultsResponses(total: Int = 10) =
            List(total) { getOlympicAthleteResultsResponse() }

        private fun getOlympicAthleteResponse() = OlympicAthleteResponse(
            "",
            getRandomString(),
            "",
            Random.nextInt(),
            getRandomString(),
            Random.nextInt(),
            getRandomString(),
            Random.nextInt(),
        )

        private fun getOlympicAthleteResultsResponse() = OlympicAthleteResultsResponse(
            Random.nextInt(),
            getRandomString(),
            Random.nextInt(),
            Random.nextInt(),
            Random.nextInt(),
        )

        private fun getGame() = OlympicGameResponse(
            getRandomString(),
            Random.nextInt(),
            Random.nextInt(),
        )

        private fun getRandomString(length: Int = 10): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }
    }
}