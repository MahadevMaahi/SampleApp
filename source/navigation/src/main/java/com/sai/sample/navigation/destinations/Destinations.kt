package com.sai.sample.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Destinations {
    fun NavGraphBuilder.create(navController: NavController)
}