package com.frhatieh.quranaya.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.frhatieh.quranaya.R
import com.frhatieh.quranaya.data.model.Verse

@Composable
fun ColumnScope.VerseScreen(
    verse: Verse,
    handleSaveClick: (Verse) -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .align(Alignment.CenterHorizontally)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = verse.text_uthmani,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
            Card(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        if (verse.isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = stringResource(id = R.string.save_icon_description),
                        modifier = Modifier.clickable {
                            handleSaveClick(verse)
                        })
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.Share, contentDescription = stringResource(id = R.string.share_icon_description))
                }
            }

        }
    }
}