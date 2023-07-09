package com.frhatieh.quranaya.ui.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.frhatieh.quranaya.R

@Composable
fun ColumnScope.ErrorScreen() {
    Spacer(modifier = Modifier.weight(1f))
    Text(
        text = stringResource(id = R.string.error_msg),
        modifier = Modifier.align(Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.weight(1f))
}