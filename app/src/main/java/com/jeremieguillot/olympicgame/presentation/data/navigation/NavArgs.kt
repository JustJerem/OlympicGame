package com.jeremieguillot.olympicgame.presentation.data.navigation

import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel

//NavArgs is used to pass complex object to the Compose Destination navigator
data class AthleteProfileNavArgs(
    val athlete: OlympicAthleteModel
)