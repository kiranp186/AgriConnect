
package com.tutorials.agriconnect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
object NavigationRoutes {
    const val HOME = "home"
    const val CATEGORIES = "categories"
    const val MY_BOOKINGS = "my_bookings"
    const val SPECIFIC_CATEGORY = "specific_category/{category}"
}


@Composable
fun SpecificCategoryScreen(category: String, onBackClick: () -> Unit) {
    // UI implementation
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
            CategoriesScreen(navController = navController, currentRoute = currentRoute)
        }

        composable(NavigationRoutes.MY_BOOKINGS) {
            // MyBookingsScreen(navController = navController, currentRoute = currentRoute)
            // For now we can just redirect back to home
            FarmersAppScreen(navController = navController, currentRoute = NavigationRoutes.MY_BOOKINGS)
        }

        composable(
            route = NavigationRoutes.SPECIFIC_CATEGORY,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            SpecificCategoryScreen(
                category = category,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}