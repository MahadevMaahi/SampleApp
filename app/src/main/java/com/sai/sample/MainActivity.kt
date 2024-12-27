package com.sai.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sai.sample.core.di.AppDependencyProvider
import com.sai.sample.navigation.destinations.Destinations
import com.sai.sample.navigation.routes.PrimaryRoutes
import com.sai.sample.common.ui.cream.foundation.SampleTheme
import com.sample.primary.navigation.PrimaryDestinations

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleTheme {
                navController = rememberNavController()
                val destinations = createDestinations()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = PrimaryRoutes.PrimaryRoute
                    ) {
                        destinations.forEach { dest ->
                            with (dest) { create(navController = navController) }
                        }
                    }
                }
            }
        }
    }

    private fun createDestinations(): List<Destinations> = listOf(
        PrimaryDestinations(
            context = applicationContext,
            navController = navController,
            appDependencyProvider = applicationContext as AppDependencyProvider
        )
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleTheme {
        Greeting("Android")
    }
}