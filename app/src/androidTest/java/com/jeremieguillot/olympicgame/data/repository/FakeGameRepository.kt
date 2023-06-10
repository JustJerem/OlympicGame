package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.jeremieguillot.olympicgame.domain.repository.GameRepository

class FakeGameRepository : GameRepository {
    override suspend fun getGames(): List<OlympicGameModel> {
        return listOf(
            OlympicGameModel(
                city = "Barcelona",
                gameId = 1,
                year = 1992,
            )
        )
    }
}