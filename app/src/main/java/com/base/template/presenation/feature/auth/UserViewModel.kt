package com.base.template.presenation.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.template.domain.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserPreferencesRepository
) : ViewModel() {

    val userName = repository.userName.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "")
    val isLoggedIn = repository.isLoggedIn.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    fun saveUser(name: String) {
        viewModelScope.launch {
            repository.saveUser(name)
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}
