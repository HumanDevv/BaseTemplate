package com.base.template.presenation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.base.template.R
import com.base.template.data.remote.model.foodItem.FoodItem
import com.base.template.presenation.theme.Orange

@Composable
fun FoodCard(foodItem: FoodItem){
    Box(
        modifier = Modifier
            .width(75.dp)
            .height(110.dp)
            .clip(RoundedCornerShape(20.dp))
    ){
        Card (
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier.fillMaxSize()
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(foodItem.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.yumquick),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 25.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                .background(color = Orange)
                .padding(horizontal = 5.dp, vertical = 4.dp)

        ){
            Text(
                text = foodItem.price,
                style = TextStyle(color = Color.White,   fontSize = 14.sp)
            )
        }
    }

}