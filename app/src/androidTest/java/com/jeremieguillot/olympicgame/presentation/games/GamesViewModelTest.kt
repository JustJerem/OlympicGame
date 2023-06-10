package com.jeremieguillot.olympicgame.presentation.games

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jeremieguillot.olympicgame.domain.interactors.GetGamesResults
import com.jeremieguillot.olympicgame.domain.interactors.common.Failure
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class GamesViewModelTest {

    private lateinit var viewModel: GamesViewModel
    private var getGamesResults: GetGamesResults = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = GamesViewModel(getGamesResults)

    }

    @Test
    fun getState() {

        coEvery {
            getGamesResults.invoke()
        } returns flow { throw Failure.NetworkConnection }

        coVerify {
            getGamesResults.invoke()
        }

        assertTrue(viewModel.state.games.isNotEmpty())
    }

    @Test
    fun setState() {
    }

    @Test
    fun getErrorEvents() {
    }
}