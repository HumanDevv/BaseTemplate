package com.base.template.data.local

import com.base.template.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class UserPreferencesRepositoryImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : UserPreferencesRepository {
    override val userName = dataStoreManager.userName
    override val isLoggedIn = dataStoreManager.isLoggedIn

    override suspend fun saveUser(name: String) = dataStoreManager.saveUser(name)
    override suspend fun logout() = dataStoreManager.logout()
}
