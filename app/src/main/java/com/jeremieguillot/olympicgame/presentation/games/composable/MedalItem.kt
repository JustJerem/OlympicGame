package com.jeremieguillot.olympicgame.presentation.games.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MedalItem(medalType: MedalType, count: Int) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(36.dp)
            .background(getMedalColor(medalType)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = count.toString(),
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
        )
    }
}

enum class MedalType {
    GOLD, SILVER, BRONZE
}

fun getMedalColor(medalType: MedalType): Color {
    return when (medalType) {
        MedalType.GOLD -> Color(0xFFD4AF37)
        MedalType.SILVER -> Color(0xFFC0C0C0)
        MedalType.BRONZE -> Color(0xFFCD7F32)
    }
}

@Composable
@Preview
fun MedalItemPreview() {
    Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        MedalItem(medalType = MedalType.GOLD, count = 5)
        MedalItem(medalType = MedalType.SILVER, count = 3)
        MedalItem(medalType = MedalType.BRONZE, count = 2)
    }
}
