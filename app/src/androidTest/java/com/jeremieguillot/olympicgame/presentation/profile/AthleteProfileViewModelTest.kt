package com.jeremieguillot.olympicgame.presentation.profile

import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jeremieguillot.olympicgame.MainCoroutineRule
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteResultsModel
import com.jeremieguillot.olympicgame.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AthleteProfileViewModelTest {

    private lateinit var viewModel: AthleteProfileViewModel
    private val coroutineRule = MainCoroutineRule()
    private val athlete = OlympicAthleteModel(
        "1",
        "",
        "Usan",
        "Bolt",
        "Description",
        "01/01/2000",
        OlympicAthleteModel.AthleteMeasurements(1, 1),
        listOf(OlympicAthleteResultsModel("Barcelona", 1992, 1, 1, 2))
    )

    @Before
    fun setUp() {
        val savedStateHandle = SavedStateHandle().apply { set("athlete", athlete) }
        viewModel = AthleteProfileViewModel(savedStateHandle)
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = coroutineRule.runBlockingTest {
        assertNotNull(viewModel.state.athleteProfile)
    }
}