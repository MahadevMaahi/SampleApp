package com.sample.primary.navigation

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sai.sample.core.di.AppDependencyProvider
import com.sai.sample.navigation.destinations.Destinations
import com.sai.sample.navigation.routes.PrimaryRoutes
import com.sai.sample.navigation.utils.viewModel
import com.sample.primary.internal.di.dagger.PrimaryComponent
import com.sample.primary.internal.di.dagger.injector.PrimaryInjector
import com.sample.primary.internal.presentation.ui.primary.PrimaryScreenRoot

class PrimaryDestinations(
    context: Context,
    navController: NavController,
    appDependencyProvider: AppDependencyProvider
): Destinations {

    private val primaryInjector: PrimaryInjector by lazy {
        PrimaryComponent.build(
            context = context,
            navController = navController,
            primaryDependencies = appDependencyProvider.getAppLevelDependency()
        )
    }

    override fun NavGraphBuilder.create(navController: NavController) {
        primaryScreenRouteDestinations(navController)
    }

    private fun NavGraphBuilder.primaryScreenRouteDestinations(navController: NavController) {
        composable<PrimaryRoutes.PrimaryRoute> {
            val primaryViewModel = viewModel { primaryInjector.primaryViewModel() }
            PrimaryScreenRoot(primaryViewModel)
        }
    }
}