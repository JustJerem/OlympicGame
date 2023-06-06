package com.jeremieguillot.olympicgame.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.presentation.data.navigation.AthleteProfileNavArgs
import com.jeremieguillot.olympicgame.presentation.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AthleteProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state by mutableStateOf(AthleteProfileContract.State())

    init {
        val navArgs: AthleteProfileNavArgs = savedStateHandle.navArgs()
        onEvent(AthleteProfileContract.Event.UpdateSelectedAthlete(navArgs.athlete))
    }

    private fun onEvent(event: AthleteProfileContract.Event) {
        when (event) {
            is AthleteProfileContract.Event.UpdateSelectedAthlete -> updateSelectedAthlete(event.athlete)
        }
    }

    private fun updateSelectedAthlete(athlete: OlympicAthleteModel) {
        state = state.copy(athleteProfile = athlete)
    }
}