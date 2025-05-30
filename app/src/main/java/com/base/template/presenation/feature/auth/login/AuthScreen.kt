package com.base.template.presenation.feature.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.base.template.R
import com.base.template.presenation.theme.Yellow
import com.base.template.utils.CustomStyledButton
import com.base.template.utils.ValidationUtils

@Composable
fun AuthScreen(navController: NavController) {
    var mobile by rememberSaveable { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopLayout()
        // Mobile No.
        OutlinedTextField(
            value = mobile,
            onValueChange = {
                if (it.length <= 10 && it.all { char -> char.isDigit() }) {
                    mobile = it
                }
            },
            label = { Text("Mobile") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            )

        Spacer(modifier = Modifier.height(10.dp))




        errorMessage.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Login Button
        CustomStyledButton(
            text = "OTP",
            onClick = {
                val error = ValidationUtils.isValidPhoneNumber(mobile)
                if (error != null) {
                    errorMessage = error
                } else {
                    errorMessage = ""
                    navController.navigate("otp")
                }

            },

            )
        Spacer(modifier = Modifier.height(16.dp))

        // Register Now
        TextButton(onClick = {
            navController.navigate("register") // Replace with your registration route
        }) {
            Text("Register Now")
        }


    }
}

@Composable
fun TopLayout() {
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




@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(navController = rememberNavController())
}
