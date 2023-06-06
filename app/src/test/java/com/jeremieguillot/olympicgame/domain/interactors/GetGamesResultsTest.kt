package com.jeremieguillot.olympicgame.domain.interactors

import com.jeremieguillot.olympicgame.data.repository.fake.FakeModelRepository
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetGamesResultsTest {

    @Mock
    private lateinit var athleteRepository: AthleteRepository

    @Mock
    private lateinit var gameRepository: GameRepository

    private lateinit var getGamesResults: GetGamesResults

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getGamesResults = GetGamesResults(athleteRepository, gameRepository)
    }

    @Test
    fun `test invoke`() = runBlocking {
        // Mock the responses from athleteRepository and gameRepository
        val games = FakeModelRepository.getGames(1)
        val athletes = FakeModelRepository.getOlympicAthleteModels()
        val athleteResults = FakeModelRepository.getOlympicAthleteResultsModels()

        `when`(gameRepository.getGames()).thenReturn(games)
        `when`(athleteRepository.getAthletes()).thenReturn(athletes)
        `when`(athleteRepository.getAthleteResults("")).thenReturn(athleteResults)

        // Call the method under test
        val result = getGamesResults.invoke().toList()

        // Verify the result
        assertNotNull(result)
    }
}