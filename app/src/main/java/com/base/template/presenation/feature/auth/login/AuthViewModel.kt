package com.base.template.presenation.feature.auth.login

import androidx.lifecycle.ViewModel
import com.base.template.domain.usecase.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _mobile = MutableStateFlow("")
    val mobile = _mobile.asStateFlow()

    fun updateMobile(number: String) {
        _mobile.value = number
    }

  /*  private val _uiState = MutableStateFlow(UiState<User>())
    val uiState: StateFlow<UiState<User>> = _uiState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)

            try {
                val user = loginUseCase(username, password)
                _uiState.value = UiState(data = user)
            } catch (e: Exception) {
                _uiState.value = UiState(error = e.message)
            }
        }*/

}
