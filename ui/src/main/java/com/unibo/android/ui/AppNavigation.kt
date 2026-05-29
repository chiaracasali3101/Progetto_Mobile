package com.unibo.android.ui
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unibo.android.ui.screens.LoginScreen
import com.unibo.android.ui.screens.RegisterScreen
import com.unibo.android.ui.screens.ProfileScreen

@Composable
fun AppNavigation() {
    // 1. Inizializziamo il navigatore
    val navController = rememberNavController()

    // 2. Creiamo la mappa. startDestination dice quale mostrare per prima (il login)
    NavHost(navController = navController, startDestination = "login") {

        // ROTTA DEL LOGIN
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("profile") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        // ROTTA DELLA REGISTRAZIONE
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("profile") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

        // ROTTA DEL PROFILO UTENTE
        composable("profile") {
            ProfileScreen()
        }
    }
}
