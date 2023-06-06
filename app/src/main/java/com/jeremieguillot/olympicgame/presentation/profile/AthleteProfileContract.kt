package com.jeremieguillot.olympicgame.presentation.profile

import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel

class AthleteProfileContract {

    sealed class Event {
        data class UpdateSelectedAthlete(val athlete: OlympicAthleteModel) : Event()
    }

    data class State(
        val athleteProfile: OlympicAthleteModel? = null
    )
}