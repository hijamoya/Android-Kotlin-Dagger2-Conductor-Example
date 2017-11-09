package com.hijamoya.example.dagger.module

import android.content.Context
import android.view.WindowManager
import com.hijamoya.example.dagger.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val application: Context) {

    @Provides
    @ActivityScope
    fun provideWindowManager(): WindowManager = application.getSystemService(Context.WINDOW_SERVICE)
            as WindowManager

}