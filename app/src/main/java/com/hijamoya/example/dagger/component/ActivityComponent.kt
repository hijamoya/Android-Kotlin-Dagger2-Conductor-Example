package com.hijamoya.example.dagger.component

import android.view.WindowManager
import com.hijamoya.example.dagger.ActivityScope
import dagger.Component
import com.hijamoya.example.dagger.module.ActivityModule
import com.hijamoya.example.MainActivity

@Component(modules = arrayOf(ActivityModule::class),
        dependencies = arrayOf(ApplicationComponent::class))
@ActivityScope
interface ActivityComponent: ApplicationComponent {

    fun windowManager(): WindowManager

    fun inject(c: MainActivity)

}