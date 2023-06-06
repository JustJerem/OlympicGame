@file:OptIn(InternalCoroutinesApi::class)

package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandler
import com.jeremieguillot.olympicgame.domain.interactors.common.Failure
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository
import kotlinx.coroutines.InternalCoroutinesApi

class AthleteRepositoryImpl(
    private val networkHandler: NetworkHandler,
    private val apiClient: OlympicApiClient
) : AthleteRepository {

    //Get All Athletes from the RemoteData API
    override suspend fun getAthletes(): List<OlympicAthleteModel> {
        if (networkHandler.isNetworkAvailable()) {
            try {
                val response = apiClient.getAthletes()
                return response.map { it.toDomainModel() }
            } catch (e: Exception) {
                throw Failure.ServerError(e.message)
            }
        } else throw Failure.NetworkConnection
    }

    //Get athlete's results from the RemoteData API
    override suspend fun getAthleteResults(id: String): List<OlympicAthleteResultsModel> {
        if (networkHandler.isNetworkAvailable()) {
            try {
                val response = apiClient.getAthleteResults(id)
                return response.map { it.toDomainModel() }
            } catch (e: Exception) {
                throw Failure.ServerError(e.message)
            }
        } else throw Failure.NetworkConnection
    }
}