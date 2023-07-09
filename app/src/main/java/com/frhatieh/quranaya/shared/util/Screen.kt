package com.frhatieh.quranaya.shared.util

const val HOME_ROUTE = "homeScreen"
const val SAVED_VERSES_SCREEN = "savedVersesScreen"

sealed class Screen(val route: String) {
    object HomeRouteScreen: Screen(route = HOME_ROUTE)
    object SavedVersesRouteScreen: Screen(route = SAVED_VERSES_SCREEN)
}