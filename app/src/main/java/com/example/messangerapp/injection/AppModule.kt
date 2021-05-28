package com.example.messangerapp.injection

import android.content.Context
import android.location.Geocoder
import androidx.datastore.preferences.createDataStore
import com.example.messangerapp.persistance.DataStoreManager
import com.example.messangerapp.utils.eventEmitters.UnauthorizedEventDispatcher
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context.createDataStore(name = "MessengerAppDataStore"))

    @Singleton
    @Provides
    fun provideUnauthorizedEventDispatcher(): UnauthorizedEventDispatcher = UnauthorizedEventDispatcher()

}