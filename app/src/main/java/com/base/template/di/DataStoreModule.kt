package com.base.template.di

/*
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = { context.dataStoreFile("app_preferences") }
        )

    @Provides
    @Singleton
    fun provideAuthLocalDataSource(dataStore: DataStore<Preferences>): AuthLocalDataSource =
        AuthLocalDataSource(dataStore)
}
*/
