@file:OptIn(InternalCoroutinesApi::class)

package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandlerImpl
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository
import kotlinx.coroutines.InternalCoroutinesApi

class AthleteRepositoryImpl(
    networkHandler: NetworkHandlerImpl,
    private val apiClient: OlympicApiClient
) : BaseRepository(networkHandler = networkHandler),
    AthleteRepository {
    override suspend fun getAthletes() {
        return request(
            call = { apiClient.getAthletes() },
            transform = { response -> response.map { it.toDomainModel() } }
        )
    }

    override suspend fun getAthlete(id: String) {
        return request(
            call = { apiClient.getAthlete(id) },
            transform = { response -> response.toDomainModel() }
        )
    }

    override suspend fun getAthleteResults(id: String) {
        return request(
            call = { apiClient.getAthleteResults(id) },
            transform = { response -> response.map { it.toDomainModel() } }
        )
    }
}