@file:OptIn(InternalCoroutinesApi::class)

package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandlerImpl
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    networkHandler: NetworkHandlerImpl,
    private val apiClient: OlympicApiClient
) : BaseRepository(networkHandler = networkHandler),
    GameRepository {
    override suspend fun getGames() {
        return request(
            call = { apiClient.getGames() },
            transform = { response -> response.map { it.toDomainModel() } }
        )
    }

    override suspend fun getAthletesInGame(gameId: String) {
        return request(
            call = { apiClient.getAthletesInGame(gameId) },
            transform = { response -> response.map { it.toDomainModel() } }
        )
    }
}