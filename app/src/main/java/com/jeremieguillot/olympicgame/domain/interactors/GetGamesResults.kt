package com.jeremieguillot.olympicgame.domain.interactors

import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import com.jeremieguillot.olympicgame.presentation.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetGamesResults @Inject constructor(
    private val athleteRepository: AthleteRepository,
    private val gameRepository: GameRepository
) {
    operator fun invoke(): Flow<Result<List<OlympicGameModel>>> = flow {
        emit(Result.Loading)

        val games = gameRepository.getGames()
        val athletes = athleteRepository.getAthletes()

        //Request results related to athletes
        athletes.forEach { athlete ->
            val athleteResult = athleteRepository.getAthleteResults(athlete.athleteId)
            athlete.results = athleteResult
        }

        //Find the athletes taking part in this game & order athlete by score
        games.forEach { game ->
            val participatingAthlete = athletes.filter { athlete ->
                athlete.results.any { it.year == game.year }
            }.sortedByDescending {
                it.results.firstOrNull { it.year == game.year }?.score
                    ?: 0
            }

            game.athletes = participatingAthlete
        }

        //Order by newer to older year
        val sortedGames = games.sortedByDescending { it.year }
        emit(Result.Success(sortedGames))

    }.catch { error ->
        Timber.e(error)
        emit(Result.Failure(error.message, error))
    }
}