package com.base.template.presenation.feature.introduction

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.base.template.presenation.theme.Shapes
import com.base.template.presenation.theme.Yellow
import com.base.template.utils.CustomStyledButton
import kotlinx.coroutines.launch

@Composable
fun IntroScreen(navController: NavHostController) {
    val onboardPages = listOf(
        OnboardPage(
            title = "Track Your Expenses",
            description = "Easily manage and track your spending anytime, anywhere.",
            bgImage = R.drawable.onboard_two,
            icon = R.drawable.transfer_document_icon
        ),
        OnboardPage(
            title = "Set Your Budget",
            description = "Plan and stick to a budget that works for you with ease.",
            bgImage = R.drawable.onboard_two,
            icon = R.drawable.card_icon
        ),
        OnboardPage(
            title = "Achieve Your Goals",
            description = "Save more and reach your financial goals faster than ever.",
            bgImage = R.drawable.onboard_three,
            icon = R.drawable.deliver_boy_icon
        )
    )

    val pagerState = rememberPagerState(pageCount = { onboardPages.size })
    val coroutineScope = rememberCoroutineScope()
    val currentPage = pagerState.currentPage

    Box(modifier = Modifier.fillMaxSize()) {
        // Background pager for scrolling effect
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(onboardPages[page].bgImage),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Foreground content
        Column(modifier = Modifier.fillMaxSize()) {

            // Skip Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp).clickable {
                        navController.navigate("auth")
                    },
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Skip",
                    style = TextStyle(color = Orange, fontSize = 16.sp),
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Skip icon",
                    tint = Orange,
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Onboarding Card
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(onboardPages[currentPage].icon),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = onboardPages[currentPage].title,
                    style = TextStyle(color = Orange, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = onboardPages[currentPage].description,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 15.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))


                // Page Indicators
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(onboardPages.size) { index ->
                        val color = if (index == currentPage) Orange else Yellow
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(RectangleShape)
                                .background(color)
                                .size(10.dp)
                        )
                    }
                }
                Spacer(modifier =Modifier.height(15.dp))

                CustomStyledButton(
                    text = if (currentPage == onboardPages.lastIndex) "Finish" else "Next"
                ) {
                    if (currentPage == onboardPages.lastIndex) {
                        navController.navigate("auth")
                    } else {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(currentPage + 1)
                        }
                    }
                }


            }


        }
    }
}


data class OnboardPage(
    val title: String,
    val description: String,
    val bgImage: Int,
    val icon: Int
)
