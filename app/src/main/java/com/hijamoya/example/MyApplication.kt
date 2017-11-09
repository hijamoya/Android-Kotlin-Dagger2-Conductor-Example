package com.hijamoya.example

import android.app.Application
import android.content.Context
import com.hijamoya.example.dagger.component.ApplicationComponent
import com.hijamoya.example.dagger.component.DaggerApplicationComponent
import com.hijamoya.example.dagger.module.AndroidModule
import com.hijamoya.example.dagger.module.ApplicationModule

class MyApplication : Application() {

    companion object {
        private var component: ApplicationComponent? = null
        fun getComponent(c: Context): ApplicationComponent {
            if (component == null) {
                component = DaggerApplicationComponent.builder()
                        .androidModule(AndroidModule(c.applicationContext))
                        .applicationModule(ApplicationModule(c.applicationContext))
                        .build()
            }
            return component!!
        }
    }

}