package com.hijamoya.example.ui

import com.hijamoya.example.dagger.injection.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides @ActivityScope fun activityName(activity: MainActivity): String {
        return activity.javaClass.name
    }
}
