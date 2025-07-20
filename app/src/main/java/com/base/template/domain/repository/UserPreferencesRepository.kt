package com.base.template.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    val userName: Flow<String?>
    val isLoggedIn: Flow<Boolean>
    suspend fun saveUser(name: String)
    suspend fun logout()
}
