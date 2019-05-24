package com.hijamoya.example.dagger.injection

import android.app.Activity

import com.hijamoya.example.ui.MainActivity
import com.hijamoya.example.ui.MainActivityComponent

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindYourActivityInjectorFactory(builder: MainActivityComponent.Builder):
            AndroidInjector.Factory<out Activity>
}
