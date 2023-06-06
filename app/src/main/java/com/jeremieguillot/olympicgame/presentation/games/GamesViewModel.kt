package com.jeremieguillot.olympicgame.presentation.games

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremieguillot.olympicgame.domain.interactors.GetGamesResults
import com.jeremieguillot.olympicgame.presentation.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getAthletes: GetGamesResults
) : ViewModel() {

    var state by mutableStateOf(GamesContract.State())

    init {
        onEvent(GamesContract.Event.RequestAthletes)
    }

    private fun onEvent(event: GamesContract.Event) {
        when (event) {
            is GamesContract.Event.RequestAthletes -> requestAthletes()
        }
    }

    private fun requestAthletes() {
        getAthletes().onEach {
            state = when (it) {
                is Result.Failure -> state.copy(isViewLoading = false)
                Result.Loading -> state.copy(isViewLoading = true)
                is Result.Success -> state.copy(isViewLoading = false, games = it.value)
            }
        }.launchIn(viewModelScope)
    }
}