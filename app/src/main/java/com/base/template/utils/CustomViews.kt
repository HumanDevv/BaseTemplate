package com.base.template.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.base.template.R
import com.base.template.presenation.theme.Orange

@Composable
fun CustomStyledButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {


    Button(
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp), // remove default padding
        shape = RoundedCornerShape(20.dp),

    ) {

            Text(text = text, style = TextStyle(fontSize = 18.sp))

    }
}

@Composable
fun TopLayout( findNavController:NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        // Back icon aligned to the start (left)
        Image(
            painter = painterResource(R.drawable.back_icon_arrow),
            contentDescription = "back",
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    findNavController.popBackStack()
                }
        )

        // Title text aligned to the center
        Text(
            text = "Screen Title",
            style = TextStyle(
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

