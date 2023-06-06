@file:OptIn(InternalCoroutinesApi::class)

package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandler
import com.jeremieguillot.olympicgame.domain.interactors.common.Failure
import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val apiClient: OlympicApiClient
) : GameRepository {

    //Get all games from the RemoteData API
    override suspend fun getGames(): List<OlympicGameModel> {
        if (networkHandler.isNetworkAvailable()) {
            try {
                return apiClient.getGames().map { it.toDomainModel() }
            } catch (e: Exception) {
                throw Failure.ServerError(e.message)
            }
        } else throw Failure.NetworkConnection
    }
}