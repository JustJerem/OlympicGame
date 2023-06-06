package com.jeremieguillot.olympicgame.presentation.games.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeremieguillot.olympicgame.R

@Composable
fun WelcomeOlympicCard() {

    val configuration = LocalConfiguration.current
    val imageWidth = configuration.screenWidthDp.dp / 3

    Card {

        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(R.string.welcome_card_title).uppercase(),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                )

                Spacer(Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_olympic_rings),
                    contentDescription = null,
                    modifier = Modifier
                        .width(imageWidth),
                    alpha = 0.6f
                )
            }

            Text(
                text = stringResource(R.string.welcome_card_subtitle),
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Preview
@Composable
fun WelcomeOlympicCardPreview() {
    WelcomeOlympicCard()
}