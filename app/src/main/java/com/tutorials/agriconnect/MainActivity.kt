package com.tutorials.agriconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tutorials.agriconnect.ui.theme.AgriconnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgriconnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CropSpecificScreen(
                        cropName = "Rice",  // or whatever crop is selected
                        onBackClick = { /* Your navigation logic */ }
                    )                }
            }
        }
    }
}

// Define navigation routes as constants
object NavigationRoutes {
    const val HOME = "home"
    const val CATEGORIES = "categories"
    const val MY_BOOKINGS = "my_bookings"
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: NavigationRoutes.HOME

    // Set up the Navigation Host with all our screens
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.HOME
    ) {
        composable(NavigationRoutes.HOME) {
            FarmersAppScreen(navController = navController, currentRoute = currentRoute)
        }
        composable(NavigationRoutes.CATEGORIES) {
            FarmTechHomeScreen().FarmTechApp(navController = navController, currentRoute = currentRoute)
        }
        composable(NavigationRoutes.MY_BOOKINGS) {
//            MyBookings(navController = navController, currentRoute = currentRoute)
        }
    }
}

@Preview(showBackground=true)
@Composable
fun APreview(){
    MainApp()
}