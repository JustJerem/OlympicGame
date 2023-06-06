package com.jeremieguillot.olympicgame.data.network.json

sealed class DataConstants(val path: String) {
    object DATA_GAMES : DataConstants("games.json")
    object DATA_ATHLETES : DataConstants("athletes.json")
    object DATA_ATHLETE_RESULTS : DataConstants("athlete_results.json")
}