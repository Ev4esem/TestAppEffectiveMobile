package com.example.navigation

sealed class NavigationFlow {

    object MainFlow : NavigationFlow()

    object SearchFlow : NavigationFlow()

    class SelectCountryFlow(val city : String, val destination : String) : NavigationFlow()

}