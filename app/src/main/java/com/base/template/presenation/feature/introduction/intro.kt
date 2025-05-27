package com.base.template.presenation.feature.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.base.template.R
import com.base.template.presenation.theme.Orange

@Composable
fun IntroScreen(navController: NavHostController) {
    Image(
        painter = painterResource(R.drawable.onboard_two),
        contentDescription = "",
        contentScale = ContentScale.FillWidth
    )
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(5.dp)
        ) {
            Text(
                text = "Skip",
                style = TextStyle(color = Orange, fontSize = 16.sp, textAlign = TextAlign.End),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Skip icon",
                tint = Orange,
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .align(Alignment.End)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                )
        ) {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.card_icon),
                contentDescription = "",
                Modifier.size(50.dp)
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = "Onboard Heading",
                style = TextStyle(color = Orange, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, conse ctetur  adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                )


        }


    }
}