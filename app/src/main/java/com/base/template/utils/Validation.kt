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
    fun isValidPhoneNumber(number: String?): Boolean {
        return !number.isNullOrBlank() && number.length in 7..15 && number.all { it.isDigit() }
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
