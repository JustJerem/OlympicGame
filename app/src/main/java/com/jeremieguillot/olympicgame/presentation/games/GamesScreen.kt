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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.mainActivity
import com.jeremieguillot.olympicgame.presentation.destinations.AthleteProfileScreenDestination
import com.jeremieguillot.olympicgame.presentation.games.composable.AthleteCard
import com.jeremieguillot.olympicgame.presentation.games.composable.EmptyGameCard
import com.jeremieguillot.olympicgame.presentation.games.composable.WelcomeOlympicCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun GamesScreen(
    viewModel: GamesViewModel = hiltViewModel(mainActivity()),
    navigator: DestinationsNavigator
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.games_screen_title))
                }
            )
        },
    ) {
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
}