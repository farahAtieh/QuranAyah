package com.frhatieh.quranaya.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.frhatieh.quranaya.ui.common.ErrorScreen
import com.frhatieh.quranaya.ui.common.LoadingScreen
import com.frhatieh.quranaya.util.LoadedState
import com.frhatieh.quranaya.util.Screen
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val verse = viewModel.verse.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home_toolbar_title)) },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(
                            route = Screen.SavedVersesRouteScreen.route
                        )
                    }) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = stringResource(id = R.string.saved_verses_icon_description)
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        }, content = { paddingValues ->
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = viewModel::onRefresh
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    when (state) {
                        LoadedState.Loading -> {
                            LoadingScreen()
                        }

                        LoadedState.Loaded -> {
                            if (verse != null) {
                                VerseScreen(
                                    verse = verse,
                                    viewModel::handleSaveClick
                                )
                            }
                        }

                        LoadedState.Error -> {
                            ErrorScreen()
                        }
                    }
                }
            }

        })
}
