package com.base.template.presenation.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.base.template.R
import com.base.template.data.remote.model.foodItem.FoodItem
import com.base.template.presenation.theme.Orange
import com.base.template.presenation.theme.Yellow

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow)
            .verticalScroll(rememberScrollState()) // 👈 makes layout scrollable

    ) {
        Spacer(modifier = Modifier.height(20.dp))

        TopLayout()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Good Morning",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 15.dp)

        )

        Text(
            text = "Rise And Shine! It's Breakfast Time",
            fontSize = 20.sp,
            color = Orange,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 15.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        MainLayout()
    }
}


@Composable
fun TopLayout() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .background(Color.White, RoundedCornerShape(25.dp))
                .padding(horizontal = 10.dp)
        ) {
            Text(
               "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .padding(end = 40.dp) // space for icon
            )
            Image(
                painter = painterResource(R.drawable.filter),
                contentDescription = "filter",
                modifier = Modifier
                    .height(35.dp)
                    .width(30.dp)
                    .align(Alignment.CenterEnd)
            )
        }


        // Icon Row
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(R.drawable.cart),
                contentDescription = "cart",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(R.drawable.notification),
                contentDescription = "notification",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "profile",
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun MainLayout() {
    val items = listOf(
        Pair(R.drawable.ic_snacks, "Snacks"),
        Pair(R.drawable.ic_meal, "Meal"),
        Pair(R.drawable.ic_vegan, "Vegan"),
        Pair(R.drawable.ic_dessert, "Dessert"),
        Pair(R.drawable.ic_drink, "Drink")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(Color.White)

            .padding(vertical =15.dp,horizontal = 15.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items) { (iconRes, label) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(80.dp)
                ) {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = label,
                        modifier = Modifier.size(width = 60.dp, height = 80.dp)
                    )
                    Text(label, style = TextStyle(fontSize = 14.sp))
                }
            }
        }



        Spacer(Modifier.size(10.dp))
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5.dp,
            color = Orange
        )
        Spacer(Modifier.size(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                ,
            horizontalArrangement = Arrangement.SpaceEvenly,
        )
        {
            Text(
                text = "Best Seller",
                modifier = Modifier.weight(0.5f),
                style = TextStyle(fontSize = 18.sp),
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "View all",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Orange
                    )
                )
                Spacer(modifier = Modifier.width(4.dp)) // Optional spacing
                Icon(
                    painter = painterResource(R.drawable.back_icon_arrow), // replace with your drawable
                    contentDescription = "arrow",
                    tint = Orange,
                    modifier = Modifier.size(14.dp).rotate(180f)
                )
            }
        }

        val foodItems = listOf(
            FoodItem("Sushi", "https://picsum.photos/200/300?1", "$103.0"),
            FoodItem("Curry Rice", "https://picsum.photos/200/300?2", "$50.0"),
            FoodItem("Lasagna", "https://picsum.photos/200/300?3", "$12.99"),
            FoodItem("Cupcake", "https://picsum.photos/200/300?4", "$8.20"),
            FoodItem("Cupcake", "https://picsum.photos/200/300?4", "$8.20"),
            FoodItem("Cupcake", "https://picsum.photos/200/300?4", "$8.20"),
        )
        LazyRow(
            contentPadding = PaddingValues( vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(foodItems) { item ->
                FoodCard(item)
            }
        }
        Spacer(modifier = Modifier.size(15.dp))
        OfferPager()
      
    }

}

@Composable
fun OfferPager(){
    val pagerState = rememberPagerState (pageCount = {10})
    HorizontalPager(state = pagerState) {page->
        Image(
            painter = painterResource(R.drawable.offer_img),
            contentDescription = "profile",
            modifier = Modifier.fillMaxWidth()
                .height(150.dp)
        )
    }
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Orange else Color.Yellow
            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(2.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(color)
                    .size(width = 20.dp, height = 5.dp)
            )
        }
    }

}

