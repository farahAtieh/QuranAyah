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
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.frhatieh.quranaya.R
import com.frhatieh.quranaya.data.model.Verse
import com.frhatieh.quranaya.shared.util.extensions.shareVerse

@Composable
fun ColumnScope.VerseScreen(
    verse: Verse,
    handleSaveClick: (Verse) -> Unit = {}
) {
    val showPopup = remember { mutableStateOf(false) }

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .align(Alignment.CenterHorizontally)
    ) {
        if (showPopup.value) {
            VerseInfoDialog(
                showPopup,
                verse
            )
        }
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
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = stringResource(id = R.string.info_icon_description),
                        Modifier
                            .padding(start = 8.dp)
                            .clickable {
                                showPopup.value = true
                            })
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.Share,
                        contentDescription = stringResource(id = R.string.share_icon_description),
                        Modifier.clickable {
                            context.shareVerse(verse.text_uthmani)
                        })

                }
            }

        }
    }
}

@Composable
fun VerseInfoDialog(
    showDialog: MutableState<Boolean>,
    verse: Verse,
) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            text = {
                Text(
                    String.format(
                        stringResource(
                            id = R.string.verse_info,
                            verse.verse_number,
                            verse.juz_number,
                            verse.page_number
                        )
                    )
                )
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(stringResource(id = R.string.close))
                }
            },
        )
    }
}