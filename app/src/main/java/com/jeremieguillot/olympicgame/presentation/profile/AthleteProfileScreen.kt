@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.jeremieguillot.olympicgame.presentation.profile

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.presentation.data.navigation.AthleteProfileNavArgs
import com.jeremieguillot.olympicgame.presentation.games.composable.MedalItem
import com.jeremieguillot.olympicgame.presentation.games.composable.MedalType
import com.jeremieguillot.olympicgame.presentation.profile.composables.AthleteProfile
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = AthleteProfileNavArgs::class)
@Composable
fun AthleteProfileScreen(
    viewModel: AthleteProfileViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val athlete = viewModel.state.athleteProfile ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "${athlete.name} details",
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.a11y_back_button)
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            //Profile athlete with measures
            item {
                AthleteProfile(athlete)
            }

            //region Medals of the athlete
            item {
                Text(
                    text = stringResource(R.string.profile_medals),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
            }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(athlete.results) { result ->
                        Card {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(
                                    text = result.city,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = result.year.toString(),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                                Row(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                ) {
                                    MedalItem(medalType = MedalType.GOLD, count = result.gold)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    MedalItem(medalType = MedalType.SILVER, count = result.silver)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    MedalItem(medalType = MedalType.BRONZE, count = result.bronze)
                                }
                            }
                        }
                    }
                }
            }
            //endregion

            //region Athlete's Biography with Animation button
            item {
                var expanded by remember { mutableStateOf(false) }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.profile_bio),
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )
                    TextButton(
                        onClick = { expanded = expanded.not() },
                    ) {
                        Text(
                            text = stringResource(
                                if (expanded) R.string.general_hide else R.string.general_see_more
                            ).uppercase(),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                val density = LocalDensity.current
                AnimatedVisibility(
                    visible = expanded,
                    enter = slideInVertically {
                        with(density) { -40.dp.roundToPx() }
                    } + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    RichText {
                        Markdown(athlete.bio.trimIndent())
                    }
                }
            }
        }
    }
}