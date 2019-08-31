package com.hijamoya.example

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any>? = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .factory()
                .create(this)
                .inject(this)
    }
}