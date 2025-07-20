package com.base.template.presenation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.base.template.presenation.feature.auth.login.AuthScreen
import com.base.template.presenation.feature.auth.otp.OtpScreen
import com.base.template.presenation.feature.home.HomeScreen
import com.base.template.presenation.feature.introduction.IntroScreen
import com.base.template.presenation.feature.introduction.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("intro") { IntroScreen(navController) }

        composable("auth") { AuthScreen(navController) }
        composable("otp") { OtpScreen(navController) }
        composable("home") { HomeScreen(navController) }
    }
}
