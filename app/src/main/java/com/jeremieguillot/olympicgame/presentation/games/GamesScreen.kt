@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.jeremieguillot.olympicgame.presentation.games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.presentation.destinations.AthleteProfileScreenDestination
import com.jeremieguillot.olympicgame.presentation.games.composable.AthleteCard
import com.jeremieguillot.olympicgame.presentation.games.composable.EmptyGameCard
import com.jeremieguillot.olympicgame.presentation.games.composable.LoadingGames
import com.jeremieguillot.olympicgame.presentation.games.composable.WelcomeOlympicCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@Destination
@RootNavGraph(start = true)
@Composable
fun GamesScreen(
    viewModel: GamesViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(key1 = snackbarHostState) {
        viewModel.errorEvents.collect { error ->
            when (error) {
                is GamesContract.Error.UnknownIssue -> scope.launch {
                    snackbarHostState.showSnackbar(
                        message = error.message.asString(context)
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.games_screen_title))
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {

        if (!viewModel.state.isViewLoading) {
            LazyColumn(
                modifier = Modifier.padding(it),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {

                item {
                    WelcomeOlympicCard()
                }

                items(viewModel.state.games) { game ->
                    Text(
                        text = game.city,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = game.year.toString(),
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(top = 8.dp)
                    ) {
                        if (game.athletes.isNotEmpty()) {
                            items(items = game.athletes) { athlete ->
                                AthleteCard(
                                    athlete,
                                    game
                                ) {
                                    navigator.navigate(
                                        AthleteProfileScreenDestination(athlete = athlete)
                                    )
                                }
                            }
                        } else {
                            item {
                                EmptyGameCard()
                            }
                        }
                    }
                }
            }
        }
        LoadingGames(isLoadingOngoing = viewModel.state.isViewLoading)
    }
}