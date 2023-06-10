package com.jeremieguillot.olympicgame.presentation.utils

sealed class Tags(val label: String) {
    object SeeMore : Tags("SeeMore")
}