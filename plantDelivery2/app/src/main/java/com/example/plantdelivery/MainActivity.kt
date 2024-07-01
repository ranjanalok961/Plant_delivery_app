package com.example.plantdelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantdelivery.Screen.Cart
import com.example.plantdelivery.Screen.Details
import com.example.plantdelivery.Screen.HomeScreen
import com.example.plantdelivery.Screen.LoginScreen
import com.example.plantdelivery.Screen.PaymentScreen
import com.example.plantdelivery.Screen.RegisterScreen
import com.example.plantdelivery.ui.theme.PlantDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            LoginScreen(
                { navController.navigate("home") },
                { navController.navigate("register") }
            )
        }
        composable("register"){
            RegisterScreen { navController.navigate("login") }
        }
        composable("home"){
            HomeScreen(
                {navController.navigate("details")},
                { navController.navigate("cart") }
            )
        }
        composable("details"){
            Details(
                { navController.navigate("cart") }
            )
        }
        composable("cart"){
            Cart { navController.navigate("payment") }
        }
        composable("payment"){
            PaymentScreen()
        }
    }
}