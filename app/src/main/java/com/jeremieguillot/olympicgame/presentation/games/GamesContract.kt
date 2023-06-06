package com.jeremieguillot.olympicgame.presentation.games

import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel

class GamesContract {

    sealed class Event {
        object RequestAthletes : Event()
    }

    data class State(
        val isViewLoading: Boolean = true,
        val games: List<OlympicGameModel> = emptyList()
    )
}