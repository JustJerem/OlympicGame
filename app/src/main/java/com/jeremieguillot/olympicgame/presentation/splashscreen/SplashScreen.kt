package com.jeremieguillot.olympicgame.presentation.splashscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.mainActivity
import com.jeremieguillot.olympicgame.presentation.destinations.GamesScreenDestination
import com.jeremieguillot.olympicgame.presentation.destinations.SplashScreenDestination
import com.jeremieguillot.olympicgame.presentation.games.GamesViewModel
import com.jeremieguillot.olympicgame.presentation.splashscreen.composables.OlympicSplashscreenLoader
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@RootNavGraph(start = true)
@Composable
fun SplashScreen(
    viewModel: GamesViewModel = hiltViewModel(mainActivity()),
    navigator: DestinationsNavigator
) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_olympic_logo))
    val progress by animateLottieCompositionAsState(composition)
    val isLoadingOngoing = viewModel.state.isViewLoading || progress != 1f
    AnimatedVisibility(
        visible = isLoadingOngoing,
        exit = fadeOut()
    ) {
        OlympicSplashscreenLoader(composition, progress)
    }

    if (!isLoadingOngoing) {
        navigator.navigate(GamesScreenDestination) {
            popUpTo(SplashScreenDestination.route) { // Remove Splashscreen from backstack
                inclusive = true
            }
        }
    }
}