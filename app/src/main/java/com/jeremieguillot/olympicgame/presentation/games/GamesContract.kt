package com.jeremieguillot.olympicgame.presentation.games

import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.jeremieguillot.olympicgame.presentation.utils.UiText

class GamesContract {

    sealed class Event {
        object RequestAthletes : Event()
    }

    sealed class Error {
        object UnknownIssue : Error() {
            val message: UiText = UiText.StringResource(
                resId = R.string.general_unknown_issue,
            )
        }
    }

    data class State(
        val isViewLoading: Boolean = true,
        val games: List<OlympicGameModel> = emptyList()
    )
}