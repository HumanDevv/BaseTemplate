package com.base.template.di

import android.content.Context
import com.base.template.data.local.DataStoreManager
import com.base.template.data.local.UserPreferencesRepositoryImpl
import com.base.template.domain.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context)

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(dataStoreManager: DataStoreManager): UserPreferencesRepository =
        UserPreferencesRepositoryImpl(dataStoreManager)
}
