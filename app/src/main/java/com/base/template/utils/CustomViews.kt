package com.base.template.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.base.template.presenation.theme.CustomBlue

@Composable
fun CustomStyledButton(
    text: String,
    onClick: () -> Unit
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF00CCFF),
            Color(0xFF0075BE).copy(alpha = 0.9f),
            Color(0xFF0075BE).copy(alpha = 0.9f),
            Color(0xFF00CCFF)
        )
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,  // make button background transparent
            contentColor = Color.White
        ),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp), // remove default padding
        shape = RoundedCornerShape(15.dp),

        modifier = Modifier
            .padding(8.dp)
            .height(50.dp)
            .fillMaxWidth()
    ) {
        // Use Box with gradient background inside Button
        Box(
            modifier = Modifier
                .background(brush = gradient, shape = RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, style = TextStyle(fontSize = 18.sp))
        }
    }
}
