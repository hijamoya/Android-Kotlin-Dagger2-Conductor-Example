package com.hijamoya.example.dagger.module

import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * A module for Android-specific dependencies which require a [android.content.Context] to create.
 */
@Module
class AndroidModule(private val application: Context) {

    @Provides
    @Singleton
    fun provideLocationManager(): LocationManager = application.getSystemService(Context
            .LOCATION_SERVICE) as LocationManager

}
