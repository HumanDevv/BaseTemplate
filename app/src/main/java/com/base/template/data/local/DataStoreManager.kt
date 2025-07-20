package com.base.template.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.dataStore

    val userName: Flow<String?> = dataStore.data
        .map { it[PreferenceKeys.USER_NAME] }

    val isLoggedIn: Flow<Boolean> = dataStore.data
        .map { it[PreferenceKeys.IS_LOGGED_IN] ?: false }

    suspend fun saveUser(name: String) {
        dataStore.edit {
            it[PreferenceKeys.USER_NAME] = name
            it[PreferenceKeys.IS_LOGGED_IN] = true
        }
    }

    suspend fun logout() {
        dataStore.edit {
            it[PreferenceKeys.IS_LOGGED_IN] = false
        }
    }
}