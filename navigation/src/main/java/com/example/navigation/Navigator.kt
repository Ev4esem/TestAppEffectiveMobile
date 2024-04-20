package com.example.navigation

import androidx.navigation.NavController

class Navigator {

    lateinit var navController : NavController

    fun navigateToFlow(navigationFlow : NavigationFlow) = when (navigationFlow) {
        NavigationFlow.MainFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMainFlow())
        NavigationFlow.SearchFlow -> {}
        is NavigationFlow.SelectCountryFlow -> navController.navigate(
            MainNavGraphDirections.actionGlobalSelectCountryFlow(
                navigationFlow.city,
                navigationFlow.destination
            )
        )
    }

}