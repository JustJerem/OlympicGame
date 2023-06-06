package com.jeremieguillot.olympicgame.domain.repository

import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel

interface GameRepository {

    suspend fun getGames(): List<OlympicGameModel>
}
