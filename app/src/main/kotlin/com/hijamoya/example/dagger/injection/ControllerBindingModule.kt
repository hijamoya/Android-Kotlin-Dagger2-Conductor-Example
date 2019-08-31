package com.hijamoya.example.dagger.injection

import com.hijamoya.example.ui.controller.HomeController
import com.hijamoya.example.ui.controller.HomeControllerComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [HomeControllerComponent::class])
abstract class ControllerBindingModule {

    @Binds
    @IntoMap
    @ClassKey(HomeController::class)
    internal abstract fun bindHomeControllerInjectorFactory(factory: HomeControllerComponent.Factory):
            AndroidInjector.Factory<*>
}
