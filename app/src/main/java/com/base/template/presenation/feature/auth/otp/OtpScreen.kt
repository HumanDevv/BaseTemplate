package com.base.template.presenation.feature.auth.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.base.template.presenation.feature.auth.UserViewModel
import com.base.template.presenation.theme.Yellow
import com.base.template.utils.CustomStyledButton
import com.base.template.utils.TopLayout
import com.base.template.utils.ValidationUtils
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun OtpScreen(navController: NavController) {
    val viewModel: UserViewModel = hiltViewModel()
    var otp by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val name by viewModel.userName.collectAsState()
    val loggedIn by viewModel.isLoggedIn.collectAsState()

    Column(modifier = Modifier.background(color = Yellow)) {
        TopLayout(navController)

        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OtpTextField(otpText = otp, onOtpTextChange = { otp = it })
            Spacer(modifier = Modifier.height(16.dp))
            errorMessage.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            CustomStyledButton(
                text = "Login",
                onClick = {
                    val error = ValidationUtils.isValidOtp(otp)
                    if (error != null) {
                        errorMessage = error
                    } else {
                        errorMessage = ""
                        viewModel.saveUser("ComposeUser")
                        navController.navigate("home")
                    }
                },

                )

        }
    }
}

@Composable
fun OtpTextField(
    otpText: String,
    onOtpTextChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    // Request focus when clicked
    LaunchedEffect(isFocused) {
        if (isFocused) {
            focusRequester.requestFocus()
        }
    }

    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null // 👈 disables ripple effect
            ) {
                isFocused = true
            }
    ) {

        // Invisible input field
        BasicTextField(
            value = otpText,
            onValueChange = {
                if (it.length <= 4 && it.all(Char::isDigit)) {
                    onOtpTextChange(it)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocused = it.isFocused
                }
                .alpha(0f)
                .width(1.dp)
                .height(1.dp),
            singleLine = true
        )
        // Visible OTP boxes
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(4) { index ->
                val char = otpText.getOrNull(index)?.toString() ?: ""
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            width = 2.dp,
                            color = if (otpText.length == index && isFocused) Color.Blue else Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = char,
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}
