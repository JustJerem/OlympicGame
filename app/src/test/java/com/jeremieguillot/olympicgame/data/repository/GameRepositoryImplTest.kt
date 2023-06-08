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
class GameRepositoryImplTest {

    @Mock
    private lateinit var networkHandler: NetworkHandler

    @Mock
    private lateinit var apiClient: OlympicApiClient

    private lateinit var repository: GameRepositoryImpl

    @Before
    fun setup() {
        repository = GameRepositoryImpl(networkHandler, apiClient)
    }

    @Test
    fun `getGames() should return a valid list of games`() = runBlocking {
        // Mock the API response
        val total = 10
        val mockResponse = FakeResponseRepository.getGames(total)
        `when`(networkHandler.isNetworkAvailable()).thenReturn(true)
        `when`(apiClient.getGames()).thenReturn(mockResponse)

        // Call the actual method
        val result = repository.getGames()

        // Assertions
        assertNotNull(result)
        assertEquals(total, result.size) // Assuming 10 athletes in the mocked response
    }
}