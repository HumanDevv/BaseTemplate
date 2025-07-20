package com.base.template.presenation.feature.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.base.template.R
import com.base.template.data.local.DataStoreManager
import com.base.template.presenation.theme.Yellow
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current
    val appDataStore = remember { DataStoreManager(context) }

    // Observe the Flow
    val isLoggedIn by appDataStore.isLoggedIn.collectAsState(initial = false)

    LaunchedEffect(Unit) {
        delay(3000)
        if (isLoggedIn) {
            navController.navigate("home")

        }
        else{
            navController.navigate("intro")

        }
    }

    Column(modifier =Modifier
        .fillMaxSize()
        .background(color = Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Image(painter = painterResource(id = R.drawable.yumquick), contentDescription = "appIcon")

    }
}