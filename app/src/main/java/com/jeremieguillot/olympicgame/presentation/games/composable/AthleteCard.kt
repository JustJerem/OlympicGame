package com.jeremieguillot.olympicgame.presentation.games.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel
import com.jeremieguillot.olympicgame.domain.model.OlympicGameModel

@Composable
fun AthleteCard(athlete: OlympicAthleteModel, game: OlympicGameModel, onClick: () -> Unit) {

    Card {
        Column(
            modifier = Modifier
                .clickable { onClick() }
                .width(180.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(athlete.photoPath)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.avatar_placeholder),
                contentDescription = stringResource(R.string.a11y_athlete_picture),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
            )

            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val result = athlete.results.first { it.year == game.year }
                MedalItem(medalType = MedalType.GOLD, count = result.gold)
                MedalItem(medalType = MedalType.SILVER, count = result.silver)
                MedalItem(medalType = MedalType.BRONZE, count = result.bronze)
            }

            Text(
                text = athlete.name,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = athlete.surname,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}
