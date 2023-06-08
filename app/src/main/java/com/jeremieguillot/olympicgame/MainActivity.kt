package com.jeremieguillot.olympicgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jeremieguillot.olympicgame.presentation.NavGraphs
import com.jeremieguillot.olympicgame.ui.theme.OlympicGameTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlympicGameTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}