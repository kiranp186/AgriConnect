package com.tutorials.agriconnect

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
import com.tutorials.agriconnect.ui.theme.AgriconnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("AgriConnectPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContent {
            AgriconnectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up navigation
                    val navController = rememberNavController()
                    val startDestination = if (isLoggedIn) "Dashboard" else "GetStarted"

                    NavHost(navController = navController, startDestination = startDestination) {
                        composable("GetStarted") {
                            getStarted {
                                navController.navigate("Login")
                            }
                        }

                        composable("Login") {
                            LoginScreen(
                                onLoginClick = {
                                    // Save login status
                                    with(sharedPreferences.edit()) {
                                        putBoolean("isLoggedIn", true)
                                        apply()
                                    }

                                    // Navigate to Dashboard
                                    navController.navigate("Dashboard") {
                                        popUpTo("GetStarted") { inclusive = true }
                                    }
                                },
                                onSignUpClick = {
                                    navController.navigate("Signup")
                                },
                                onForgotClick = {
                                    // Handle forgot password - no navigation needed here
                                }
                            )
                        }

                        composable("Signup") {
                            SignupScreen {
                                // Save login status
                                with(sharedPreferences.edit()) {
                                    putBoolean("isLoggedIn", true)
                                    apply()
                                }

                                // Navigate to Dashboard
                                navController.navigate("Dashboard") {
                                    popUpTo("GetStarted") { inclusive = true }
                                }
                            }
                        }

                        composable("Dashboard") {
                            FarmersAppScreen()
                        }
                    }
                }
            }
        }
    }
}