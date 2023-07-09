package com.frhatieh.quranaya.ui.savedverses

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.frhatieh.quranaya.R
import com.frhatieh.quranaya.ui.common.EmptyScreen
import com.frhatieh.quranaya.ui.common.ErrorScreen
import com.frhatieh.quranaya.util.LoadedState
import com.frhatieh.quranaya.ui.common.LoadingScreen
import com.frhatieh.quranaya.ui.home.VerseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedVersesScreen(navController: NavHostController) {
    val viewModel: SavedVersesViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val verses by viewModel.verses.collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.saved_verses_toolbar_title)) },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_icon_description),
                        Modifier.clickable {
                            navController.navigateUp()
                        }
                    )
                },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                when (state) {
                    LoadedState.Loading -> {
                        LoadingScreen()
                    }

                    LoadedState.Loaded -> {
                        if (verses.isEmpty()) {
                            EmptyScreen()
                        } else {
                            LazyColumn(
                                content = {
                                    items(verses) { verse ->
                                        VerseScreen(verse = verse, viewModel::unSaveVerse)
                                    }
                                })
                        }
                    }

                    LoadedState.Error -> {
                        ErrorScreen()
                    }
                }
            }
        }
    )

}