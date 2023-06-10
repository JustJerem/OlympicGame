package com.jeremieguillot.olympicgame.presentation.games

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.flow.emptyFlow
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GamesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun games_emptyGames() {
        startGamesScreen(emptyList())
        composeTestRule.onNodeWithText(context.getString(R.string.games_screen_title))
            .assertIsDisplayed()
    }

    @Test
    fun games_displayGame() {
        val games = listOf(
            OlympicGameModel(1, "Barcelona", 1992),
        )
        startGamesScreen(games)
        // Confirm empty view is display on empty game
        composeTestRule.onNodeWithText(context.getString(R.string.empty_game_card_description))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.games_screen_title))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(games.first().city).assertIsDisplayed()
    }

    @Test
    fun games_displayGames() {
        val games = listOf(
            OlympicGameModel(1, "Barcelona", 1992),
            OlympicGameModel(2, "Paris", 2024)
                .apply {
                    athletes = listOf(
                        OlympicAthleteModel(
                            "1",
                            "",
                            "Usan",
                            "Bolt",
                            "Description",
                            "01/01/2000",
                            OlympicAthleteModel.AthleteMeasurements(1, 1),
                            listOf(OlympicAthleteResultsModel("Barcelona", 1992, 1, 1, 2))
                        )
                    )
                },
        )
        startGamesScreen(games)
        // Confirm empty view is display on empty game
        composeTestRule.onNodeWithText(context.getString(R.string.empty_game_card_description))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.games_screen_title))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(games.first().city).assertIsDisplayed()
        composeTestRule.onNodeWithText(games.last().city).assertIsDisplayed()
        val athlete = games.last().athletes.first()
        composeTestRule.onNodeWithText("${athlete.name} ${athlete.surname}").assertIsDisplayed()
    }

    private fun startGamesScreen(games: List<OlympicGameModel>) {
        composeTestRule.setContent {
            GamesScreen(
                GamesContract.State(isViewLoading = false, games),
                EmptyDestinationsNavigator,
                emptyFlow()
            )
        }
    }
}
