package com.hijamoya.example.dagger.component

import android.content.Context
import android.location.LocationManager
import com.hijamoya.example.dagger.ApplicationContext
import dagger.Component
import com.hijamoya.example.dagger.module.AndroidModule
import com.hijamoya.example.dagger.module.ApplicationModule
import javax.inject.Singleton

@Component(modules = arrayOf(ApplicationModule::class, AndroidModule::class))
@Singleton
interface ApplicationComponent {

    @ApplicationContext
    fun appContext(): Context

    fun locationManager(): LocationManager

}