package com.base.template.data.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    val USER_NAME = stringPreferencesKey("user_name")
    val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
}
