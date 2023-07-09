package com.frhatieh.quranaya.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frhatieh.quranaya.ui.savedverses.SavedVersesScreen
import com.frhatieh.quranaya.ui.theme.QuranAyahTheme
import com.frhatieh.quranaya.shared.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuranAyahTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeRouteScreen.route
                    ) {
                        composable(
                            Screen.HomeRouteScreen.route
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            Screen.SavedVersesRouteScreen.route
                        ) {
                            SavedVersesScreen(navController)
                        }
                    }
                }
            }
        }
    }
}