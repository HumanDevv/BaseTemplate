package com.base.template.utils

object ValidationUtils {

    // Check if a field is not empty
    fun isNotEmpty(input: String?): Boolean {
        return !input.isNullOrBlank()
    }

    // Check if input is a valid email
    fun isValidEmail(email: String?): Boolean {
        return !email.isNullOrBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Check if input is a valid phone number (basic validation)
    fun isValidPhoneNumber(number: String?): String? {
        return when {
            number.isNullOrBlank() -> "Mobile number is required"
            number.length != 10 -> "Mobile number must be exactly 10 digits"
            !number.all { it.isDigit() } -> "Mobile number must contain only digits"
            else -> null
        }
    }
    // Check if input is a valid phone number (basic validation)
    fun isValidOtp(otp: String?): String? {
        return when {
            otp.isNullOrBlank() -> "Otp is required"
            otp.length != 4 -> "Otp must be exactly 4 digits"
            !otp.all { it.isDigit() } -> "Otp must contain only digits"
            else -> null
        }
    }

    // Check if input is a valid password (min 6 chars, one digit, one letter)
    fun isValidPassword(password: String?): Boolean {
        return !password.isNullOrBlank() &&
                password.length >= 6 &&
                password.any { it.isDigit() } &&
                password.any { it.isLetter() }
    }

    // Optional: Confirm password matches
    fun isPasswordMatch(password: String?, confirmPassword: String?): Boolean {
        return password == confirmPassword
    }
}
