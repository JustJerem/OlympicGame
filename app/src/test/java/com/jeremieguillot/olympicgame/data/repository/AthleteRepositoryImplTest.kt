package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandler
import com.jeremieguillot.olympicgame.data.repository.fake.FakeResponseRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AthleteRepositoryImplTest {

    @Mock
    private lateinit var networkHandler: NetworkHandler

    @Mock
    private lateinit var apiClient: OlympicApiClient

    private lateinit var repository: AthleteRepositoryImpl

    @Before
    fun setup() {
        repository = AthleteRepositoryImpl(networkHandler, apiClient)
    }

    @Test
    fun `getAthletes() should return a valid list of athletes`() = runBlocking {
        // Mock the API response
        val total = 10
        val mockResponse = FakeResponseRepository.getOlympicAthleteResponses(total)

        `when`(networkHandler.isNetworkAvailable()).thenReturn(true)
        `when`(apiClient.getAthletes()).thenReturn(mockResponse)

        // Call the actual method
        val result = repository.getAthletes()

        // Assertions
        assertNotNull(result)
        assertEquals(total, result.size) // Assuming 10 athletes in the mocked response
    }

    @Test
    fun `test getAthleteResults`() = runBlocking {
        // Mock the response from apiClient
        val total = 10
        val athleteResults = FakeResponseRepository.getOlympicAthleteResultsResponses(total)
        `when`(networkHandler.isNetworkAvailable()).thenReturn(true)
        `when`(apiClient.getAthleteResults("1")).thenReturn(athleteResults)

        // Call the method under test
        val result = repository.getAthleteResults("1")

        // Verify the result
        assertEquals(athleteResults.map { it.toDomainModel() }, result)
    }
}