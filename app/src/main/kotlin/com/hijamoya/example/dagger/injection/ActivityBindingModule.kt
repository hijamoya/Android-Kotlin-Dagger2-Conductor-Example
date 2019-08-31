package com.hijamoya.example.dagger.injection

import com.hijamoya.example.ui.MainActivity
import com.hijamoya.example.ui.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindYourAndroidInjectorFactory(factory: MainActivityComponent.Factory):
            AndroidInjector.Factory<*>
}
