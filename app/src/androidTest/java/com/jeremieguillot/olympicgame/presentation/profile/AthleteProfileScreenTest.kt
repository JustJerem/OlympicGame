package com.jeremieguillot.olympicgame.presentation.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.presentation.utils.Tags
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AthleteProfileScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    val athlete = OlympicAthleteModel(
        "1",
        "",
        "Usan",
        "Bolt",
        "Biography",
        "01/01/2000",
        OlympicAthleteModel.AthleteMeasurements(1, 1),
        listOf(
            OlympicAthleteResultsModel("Barcelona", 1992, 1, 1, 2),
            OlympicAthleteResultsModel("London", 2012, 2, 1, 0),
        )
    )

    @Test
    fun athlete_displayProfile() {
        startAthleteScreen(athlete)
        composeTestRule.onNodeWithTag(Tags.SeeMore.label).performClick()
        composeTestRule.onNodeWithText(athlete.dateOfBirth).assertIsDisplayed()
        composeTestRule.onNodeWithText(athlete.bio).assertIsDisplayed()
        composeTestRule.onNodeWithText(athlete.results.first().city).assertIsDisplayed()
        composeTestRule.onNodeWithText(athlete.results.first().year.toString()).assertIsDisplayed()
    }

    private fun startAthleteScreen(athlete: OlympicAthleteModel) {
        composeTestRule.setContent {
            AthleteProfileScreen(
                athlete,
                EmptyDestinationsNavigator
            )
        }
    }
}