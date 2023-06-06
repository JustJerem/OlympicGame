package com.jeremieguillot.olympicgame.presentation.profile.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.Scale
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jeremieguillot.olympicgame.R
import com.jeremieguillot.olympicgame.domain.model.OlympicAthleteModel

@Composable
fun AthleteProfile(athleteProfile: OlympicAthleteModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(athleteProfile.photoPath)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.avatar_placeholder),
            contentDescription = stringResource(R.string.a11y_athlete_picture),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(120.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = "${athleteProfile.name} ${athleteProfile.surname}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.width(16.dp))
            AthleteInfoItem(Icons.Outlined.Cake, athleteProfile.dateOfBirth)
            AthleteInfoItem(
                Icons.Outlined.Scale,
                athleteProfile.measurements.weight.toString() + stringResource(R.string.profile_detail_abbreviation_kilo)
            )
            AthleteInfoItem(
                Icons.Default.Height,
                athleteProfile.measurements.height.toString() + stringResource(R.string.profile_detail_abbreviation_centimeter)
            )
        }
    }
}

